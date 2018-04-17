package ekeneya.back.models.dto;

import java.io.Serializable;

/**
 * 
 * @author zakaridia
 *
 */
public class StructureDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3124849879836286196L;

	private Long id;

	private String name;

	private Double latitude;

	private Double longitude;

	private String tel;

	private VilleDTO ville;

	private TypeStructureDTO type;

	public StructureDTO() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the ville
	 */
	public VilleDTO getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(VilleDTO ville) {
		this.ville = ville;
	}

	/**
	 * @return the type
	 */
	public TypeStructureDTO getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeStructureDTO type) {
		this.type = type;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

}
