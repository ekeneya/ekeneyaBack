package ekeneya.back.services;

import java.util.Optional;

import ekeneya.back.exceptions.ApiExceptions;
import ekeneya.back.models.dto.ListStructureDTO;
import ekeneya.back.models.dto.SearchStructureParams;
import ekeneya.back.models.dto.StructureDTO;

public interface IStructureService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<StructureDTO> selectById(Long id);
	
	/**
	 * 
	 * @return
	 */
	long count();

	/**
	 * *O
	 * @param structureDTO
	 * @return
	 * @throws ApiExceptions 
	 */
	StructureDTO save(StructureDTO structureDTO) throws ApiExceptions;
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	Optional<ListStructureDTO> searchStructures(SearchStructureParams params);


}
