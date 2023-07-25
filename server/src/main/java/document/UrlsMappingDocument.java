package document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

@Document("RedirectRecord")
public class UrlsMappingDocument {

	@Id
	String id;
	@NonNull
	@Field("domain")
	private String domain;
	@Field("tinyurl")
	private String tinyurl;
	@Field("isTinyUrlActive")
	private boolean isTinyUrlActive = true;
	@Field("created_date")
	private LocalDateTime created_date;

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTinyurl() {
		return tinyurl;
	}

	public void setTinyurl(String tinyurl) {
		this.tinyurl = tinyurl;
	}

	public boolean isTinyUrlActive() {
		return isTinyUrlActive;
	}

	public void setTinyUrlActive(boolean isTinyUrlActive) {
		this.isTinyUrlActive = isTinyUrlActive;
	}

}
