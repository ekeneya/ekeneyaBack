package ekeneya.back.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ekeneya.back.models.dto.ListVilleDTO;
import ekeneya.back.services.IVilleService;


@RestController
@RequestMapping(path = "/api/villes")
public class VilleApiController{
	
	@Autowired
	private IVilleService villeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<ListVilleDTO> getVilles() {
		Optional<ListVilleDTO> listVilleDTO =  villeService.selectVilles();
		if(listVilleDTO.isPresent()){			
			return ResponseEntity.ok(listVilleDTO.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	

}
