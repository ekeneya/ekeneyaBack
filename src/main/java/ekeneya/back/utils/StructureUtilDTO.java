package ekeneya.back.utils;

import ekeneya.back.models.dto.StructureDTO;
import ekeneya.back.models.dto.TypeStructureDTO;
import ekeneya.back.models.dto.VilleDTO;
import ekeneya.back.models.entities.Structure;
import ekeneya.back.models.entities.TypeStructure;
import ekeneya.back.models.entities.Ville;

public class StructureUtilDTO {
	
	private StructureUtilDTO() {
		throw new IllegalStateException("Utility class");
	}
	
	public static StructureDTO convertToDTO(Structure structure){
		if(structure == null){
			return null;
		}
		
		StructureDTO structureDTO = new StructureDTO();
		structureDTO.setId(structure.getId());
		structureDTO.setLatitude(structure.getLatitude());
		structureDTO.setLongitude(structure.getLongitude());
		structureDTO.setName(structure.getName());
		structureDTO.setTel(structure.getTel());
		
		Ville ville = structure.getVille();
		if(ville != null){
			structureDTO.setVille(VilleUtilDTO.convertToDTO(ville));
		}
		
		TypeStructure type = structure.getType();
		if(type != null){
			structureDTO.setType(TypeStructureUtilDTO.convertToDTO(type));
		}
		return structureDTO;
	}

	public static Structure convertToEntity(StructureDTO structureDTO) {
		if(structureDTO == null){
			return null;
		}
		
		Structure structure = new Structure();
		structure.setId(structureDTO.getId());
		structure.setLatitude(structureDTO.getLatitude());
		structure.setLongitude(structureDTO.getLongitude());
		structure.setName(structureDTO.getName());
		structure.setTel(structureDTO.getTel());
		
		VilleDTO villeDTO = structureDTO.getVille();
		if(villeDTO != null){
			structure.setVille(VilleUtilDTO.convertToEntity(villeDTO));
		}
		
		TypeStructureDTO typeDTO = structureDTO.getType();
		if(typeDTO != null){
			structure.setType(TypeStructureUtilDTO.convertToEntity(typeDTO));
		}
		return structure;
	}

}
