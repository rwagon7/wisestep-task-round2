import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import document.UrlsMappingDocument;
import repository.RedirectURLRepository;

@Component
public class ScheduledTask {

    private final RedirectURLRepository repository;

    @Autowired
    public YourScheduledTask(RedirectURLRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 300000) 
    public void updateFieldValue() {

        LocalDateTime starttime = LocalDateTime.now();
        LocalDateTime endtime = LocalDateTime.now().plusMinutes(5l);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(yyyy-MM-dd HH:mm:ss);

        List<UrlsMappingDocument> documentsToUpdate = repository.findTokensInBetween(starttime.format(dateFormatter).toString(),endtime.format(dateFormatter).toString());

        for (UrlsMappingDocument document : documentsToUpdate) {
            document.setTinyUrlActive(false);
            repository.save(document);
        }
    }