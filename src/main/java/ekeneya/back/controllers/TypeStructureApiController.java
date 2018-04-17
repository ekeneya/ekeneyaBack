package ekeneya.back.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ekeneya.back.models.dto.ListTypeStructureDTO;
import ekeneya.back.services.ITypeStructureService;


@RestController
@RequestMapping(path = "/api/types")
public class TypeStructureApiController{
	
	@Autowired
	private ITypeStructureService typeService;
			
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<ListTypeStructureDTO> getType() {
		Optional<ListTypeStructureDTO> listType =  typeService.selectTypeStructures();
		if(listType.isPresent()){			
			return ResponseEntity.ok(listType.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	

}
