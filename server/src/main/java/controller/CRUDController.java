package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.IOopration;
import document.UrlsMappingDocument;
import service.CRUDService;
import service.RandomUrlGenerator;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("ws")
public class CRUDController {


	private final CRUDService crudService;
	private final RandomUrlGenerator RandomUrlGenerator;

	@Autowired
	CRUDController(CRUDService crudService, service.RandomUrlGenerator randomUrlGenerator) {

		this.crudService = crudService;
		RandomUrlGenerator = randomUrlGenerator;
	}

//	@GetMapping

	@CrossOrigin(origins = "*")
	@PostMapping("save")
	public ResponseEntity<UrlsMappingDocument> saveData(@RequestBody IOopration request) {

		ResponseEntity<UrlsMappingDocument> res = null;
		try {

			UrlsMappingDocument doc = new UrlsMappingDocument();
			doc.setDomain(request.getDomain());
			doc.setTinyurl(service.RandomUrlGenerator.getRandomAlphaString(0));
			UrlsMappingDocument urlsMappingDocument = crudService.acceptingURl(doc);

			if(urlsMappingDocument != null)
				res = new ResponseEntity<UrlsMappingDocument>(doc, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return new ResponseEntity<UrlsMappingDocument>(HttpStatus.BAD_REQUEST);
	}

//	
//	@PutMapping
//	
//	@DeleteMapping

}
