package ekeneya.back.utils;

import ekeneya.back.models.dto.VilleDTO;
import ekeneya.back.models.entities.Ville;

public class VilleUtilDTO {

	private VilleUtilDTO() {
		throw new IllegalStateException("Utility class");
	}

	public static VilleDTO convertToDTO(Ville ville) {
		if (ville == null) {
			return null;
		}
		return new VilleDTO(ville);
	}

	public static Ville convertToEntity(VilleDTO villeDTO) {
		if (villeDTO == null) {
			return null;
		}
		Ville ville = new Ville();
		ville.setCode(villeDTO.getCode());
		return ville;
	}
}
