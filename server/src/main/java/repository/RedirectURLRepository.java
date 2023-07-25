package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.mongodb.lang.Nullable;

import document.UrlsMappingDocument;

@Repository
public interface RedirectURLRepository extends MongoRepository<UrlsMappingDocument, String> {

	@Nullable
	@Query("{ 'tinyurl' : ?0, 'isTinyUrlActive' : true , $sample:{size:1} }")
	public UrlsMappingDocument isAValidEndPoint(String endpoint);
	
	@Nullable
	@Query("{ tinyurl : ?0}")
	public UrlsMappingDocument findByTinyUrl(String tinyurl);
	
}
