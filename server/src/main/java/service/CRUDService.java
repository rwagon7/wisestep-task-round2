package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import document.UrlsMappingDocument;
import repository.RedirectURLRepository;

@Service
public class CRUDService {

	private final RedirectURLRepository repository;
	
	
	@Autowired
	CRUDService(RedirectURLRepository repository){
		this.repository = repository;
	}
	
	
	public boolean isAValidTinyUrl(String endpoint) {
		UrlsMappingDocument urldetails =repository.isAValidEndPoint(endpoint);
		return urldetails.isTinyUrlActive();
	}
	
	public  UrlsMappingDocument acceptingURl(UrlsMappingDocument UrlDetails){
		UrlsMappingDocument output = repository.save(UrlDetails);
		return output;
	}
	
	public UrlsMappingDocument getDocByTinyUrl(String tinyUrl) {
		UrlsMappingDocument document = repository.findByTinyUrl(tinyUrl);
		return document;
	}
}
