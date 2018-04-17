package ekeneya.back.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ekeneya.back.models.dto.ListTypeStructureDTO;
import ekeneya.back.models.dto.TypeStructureDTO;
import ekeneya.back.models.entities.TypeStructure;
import ekeneya.back.repositories.ITypeStructureRepository;
import ekeneya.back.utils.TypeStructureUtilDTO;


@Service
public class TypeStructureService implements ITypeStructureService{
	
	@Autowired
	ITypeStructureRepository typeRepository;
	
	@Override
	public Optional<TypeStructure> selectById(Long id) {
		if(id==null){
			return Optional.empty();
		}
		return typeRepository.findById(id);
	}
	

	@Override
	public Optional<ListTypeStructureDTO> selectTypeStructures() {
		return convertToDTO(typeRepository.findAll(Sort.by(Sort.Direction.ASC,"libelle")));
	}
	
	/***
	 * 
	 * @param types
	 * @return
	 */
	private Optional<ListTypeStructureDTO> convertToDTO(List<TypeStructure> types){
		if(types == null){
			return Optional.empty();
		}
		List<TypeStructureDTO> typesDTO = types.stream().map(TypeStructureUtilDTO::convertToDTO).collect(Collectors.toList());
		ListTypeStructureDTO listTypeStructureDTO = new ListTypeStructureDTO();
		listTypeStructureDTO.setTypes(typesDTO);
		return Optional.of(listTypeStructureDTO); 
	}


	@Override
	public TypeStructure selectByCode(String code) {
		return typeRepository.findByCode(code);
	}


	@Override
	public TypeStructure save(TypeStructure type) {
		return typeRepository.save(type);
	}


	@Override
	public long count() {
		return typeRepository.count();
	}


	@Override
	public boolean fieldValueExist(Object value, String field) {
		return false;
	}
	
}
