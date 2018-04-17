package ekeneya.back.models.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zakaridia
 *
 */
public class ListTypeStructureDTO implements Serializable{

	private static final long serialVersionUID = -5234723414994142814L;
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private List<TypeStructureDTO> types;

	/**
	 * @return the types
	 */
	public List<TypeStructureDTO> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(List<TypeStructureDTO> types) {
		this.types = types;
	}

	
	
	
}
