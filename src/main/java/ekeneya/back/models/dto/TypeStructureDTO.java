package ekeneya.back.models.dto;

import java.io.Serializable;

import ekeneya.back.models.entities.TypeStructure;

/**
 * 
 * @author zakaridia
 *
 */
public class TypeStructureDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7885252303002512673L;

	private Long id;

	private String code;

	private String libelle;

	public TypeStructureDTO() {
		super();
	}

	public TypeStructureDTO(TypeStructure type) {
		this.code = type.getCode();
		this.id = type.getId();
		this.libelle = type.getLibelle();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeStructureDTO [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}

}
