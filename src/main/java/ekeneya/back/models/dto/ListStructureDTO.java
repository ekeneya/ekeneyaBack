package ekeneya.back.models.dto;

import java.io.Serializable;
import java.util.List;

public class ListStructureDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1898889494300419697L;
	
	/**
	 * 
	 */
	private long nombreStructure;

	/**
	 * 
	 */
	private List<StructureDTO> structures;

	/**
	 * @return the nombreStructure
	 */
	public long getNombreStructure() {
		return nombreStructure;
	}

	/**
	 * @param nombreStructure the nombreStructure to set
	 */
	public void setNombreStructure(long nombreStructure) {
		this.nombreStructure = nombreStructure;
	}

	/**
	 * @return the structures
	 */
	public List<StructureDTO> getStructures() {
		return structures;
	}

	/**
	 * @param structures the structures to set
	 */
	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}

}
