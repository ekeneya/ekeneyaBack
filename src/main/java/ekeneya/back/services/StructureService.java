package ekeneya.back.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ekeneya.back.exceptions.ApiException;
import ekeneya.back.exceptions.ApiExceptions;
import ekeneya.back.models.dto.ListStructureDTO;
import ekeneya.back.models.dto.SearchStructureParams;
import ekeneya.back.models.dto.StructureDTO;
import ekeneya.back.models.entities.Structure;
import ekeneya.back.models.entities.TypeStructure;
import ekeneya.back.models.entities.Ville;
import ekeneya.back.repositories.IStructureRepository;
import ekeneya.back.specifications.StructureSpecifications;
import ekeneya.back.utils.EntityValidator;
import ekeneya.back.utils.StructureUtilDTO;

@Service
public class StructureService implements IStructureService {

	@Autowired
	IStructureRepository structureRepository;

	@Autowired
	IVilleService villeService;

	@Autowired
	ITypeStructureService typeService;

	@Autowired
	EntityValidator<Structure> validator;

	@Override
	public Optional<StructureDTO> selectById(Long id) {
		Optional<Structure> structure = structureRepository.findById(id);
		if (structure.isPresent()) {
			return Optional.of(StructureUtilDTO.convertToDTO(structure.get()));
		}
		return Optional.empty();
	}

	@Override
	public long count() {
		return structureRepository.count();
	}

	@Override
	public StructureDTO save(StructureDTO structureDTO) throws ApiExceptions {

		final Structure structure = StructureUtilDTO.convertToEntity(structureDTO);

		ApiExceptions apiExceptions = validator.validateEntite(structure);

		apiExceptions.getExceptions().addAll(checkTypeAndVille(structure).getExceptions());

		if(!apiExceptions.getExceptions().isEmpty()){
			throw apiExceptions;
		}
		
		return StructureUtilDTO.convertToDTO(structureRepository.save(structure));
	}

	/**
	 * 
	 * @param structure
	 * @return
	 */
	private ApiExceptions checkTypeAndVille(Structure structure) {
		final ApiExceptions apiExceptions = new ApiExceptions();
		if (!checkVille(structure)) {
			apiExceptions.addException(new ApiException("ville", "error.structure.ville"));
		}
		if (!checkType(structure)) {
			apiExceptions.addException(new ApiException("type", "error.structure.type"));
		}
		return apiExceptions;
	}

	/**
	 * 
	 * @param structure
	 * @return
	 */
	private boolean checkVille(Structure structure) {
		final Ville ville = structure.getVille();
		if (ville == null || ville.getCode() == null) {
			return false;
		}
		final Ville laVille = villeService.selectByCode(ville.getCode());
		if (laVille == null) {
			return false;
		}
		structure.setVille(laVille);
		return true;
	}

	/**
	 * 
	 * @param structure
	 * @return
	 */
	private boolean checkType(Structure structure) {
		final TypeStructure type = structure.getType();
		if (type == null || type.getCode() == null) {
			return false;
		}
		final TypeStructure typeExistant = typeService.selectByCode(type.getCode());
		if (typeExistant == null) {
			return false;
		}
		structure.setType(typeExistant);
		return true;
	}

	/**
	 * 
	 * @param structures
	 * @return
	 */
	private Optional<ListStructureDTO> convertToListStructureDTO(Page<Structure> structures) {

		if (structures == null) {
			return Optional.empty();
		}

		ListStructureDTO listStructureDTO = new ListStructureDTO();

		List<Structure> contents = structures.getContent();

		listStructureDTO
				.setStructures(contents.stream().map(StructureUtilDTO::convertToDTO).collect(Collectors.toList()));
		listStructureDTO.setNombreStructure(structures.getTotalElements());

		return Optional.of(listStructureDTO);
	}

	@Override
	public Optional<ListStructureDTO> searchStructures(SearchStructureParams params) {

		Integer page = params.getPage();
		if (page == null || page < 0) {
			page = 0;
		}

		Integer size = params.getSize();
		if (size == null || size < 0) {
			size = 10;
		}

		Page<Structure> structures = structureRepository.findAll(StructureSpecifications.search(params),
				PageRequest.of(page, size));

		return convertToListStructureDTO(structures);
	}

}
