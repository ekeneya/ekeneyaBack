package ekeneya.back.utils;

import ekeneya.back.models.dto.TypeStructureDTO;
import ekeneya.back.models.entities.TypeStructure;

public class TypeStructureUtilDTO {

	private TypeStructureUtilDTO() {
		throw new IllegalStateException("Utility class");
	}

	public static TypeStructureDTO convertToDTO(TypeStructure type) {
		if (type == null) {
			return null;
		}
		return new TypeStructureDTO(type);
	}

	public static TypeStructure convertToEntity(TypeStructureDTO typeDTO) {
		if (typeDTO == null) {
			return null;
		}
		TypeStructure type = new TypeStructure();
		type.setCode(typeDTO.getCode());
		return type;
	}
}
