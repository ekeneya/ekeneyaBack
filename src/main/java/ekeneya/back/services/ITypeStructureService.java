package ekeneya.back.services;

import java.util.Optional;

import ekeneya.back.models.dto.ListTypeStructureDTO;
import ekeneya.back.models.entities.TypeStructure;

public interface ITypeStructureService extends IFieldValueExist{
	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<TypeStructure> selectById(final Long id);
	
	/***
	 * 
	 * @param code
	 * @return
	 */
	TypeStructure selectByCode(final String code);
	
	/**
	 * 
	 * @return
	 */
	Optional<ListTypeStructureDTO> selectTypeStructures();

	/**
	 * 
	 * @param type
	 * @return
	 */
	TypeStructure save(TypeStructure type);

	/***
	 * 
	 * @return
	 */
	long count();
}
