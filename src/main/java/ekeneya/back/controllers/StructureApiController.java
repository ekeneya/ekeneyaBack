package ekeneya.back.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ekeneya.back.exceptions.ApiExceptions;
import ekeneya.back.models.dto.ListStructureDTO;
import ekeneya.back.models.dto.SearchStructureParams;
import ekeneya.back.models.dto.StructureDTO;
import ekeneya.back.services.IStructureService;

@RestController
@RequestMapping(path="/api/structures")
public class StructureApiController {

	@Autowired
	IStructureService structureService;

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public ResponseEntity<StructureDTO> enregistrer(@RequestBody StructureDTO structureDTO) throws ApiExceptions {
		return ResponseEntity.ok(structureService.save(structureDTO));
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StructureDTO> getStructure(@PathVariable("id") Long id) {
		Optional<StructureDTO> structureDTO = structureService.selectById(id);
		if(structureDTO.isPresent()){
			return ResponseEntity.ok(structureDTO.get());
		}
		return ResponseEntity.notFound().build();
	}
		
	
	
	@RequestMapping(value = "/chercher", method = RequestMethod.POST)
	public ResponseEntity<ListStructureDTO> chercher(@RequestBody SearchStructureParams params) {
		
		Optional<ListStructureDTO> listStructureDTO = structureService.searchStructures(params);

		if (listStructureDTO.isPresent()) {
			return ResponseEntity.ok(listStructureDTO.get());
		}

		return ResponseEntity.noContent().build();
		
	}

}
