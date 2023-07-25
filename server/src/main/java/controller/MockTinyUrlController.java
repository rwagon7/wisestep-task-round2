package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import service.CRUDService;

@RestController
@CrossOrigin(origins = "*")
public class MockTinyUrlController {

	private final CRUDService crudService;

	@Autowired
	public MockTinyUrlController(CRUDService crudService) {;
		this.crudService = crudService;
	}

	@GetMapping("mytinyurl/{endpoint}")
	public void routeToActualURL(@PathParam("endpoint") String endpoint, HttpServletResponse response)
			throws IOException {
		boolean validatiingVariable = crudService.isAValidTinyUrl(endpoint);
		if (validatiingVariable) {
			String domain = crudService.getDocByTinyUrl(endpoint).getDomain();
			response.sendRedirect(domain);
		}
	}

}
