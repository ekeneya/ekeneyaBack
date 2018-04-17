package ekeneya.back.models.dto;

import java.io.Serializable;

import ekeneya.back.models.entities.Ville;

/**
 * 
 * @author zakaridia
 *
 */
public class VilleDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 870743641786671216L;

	private Long id;

	private String code;

	private String libelle;

	public VilleDTO() {
		super();
	}

	public VilleDTO(Ville ville) {
		this.code = ville.getCode();
		this.id = ville.getId();
		this.libelle = ville.getLibelle();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VilleDTO [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}

}
