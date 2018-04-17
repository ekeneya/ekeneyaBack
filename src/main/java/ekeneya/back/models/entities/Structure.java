package ekeneya.back.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ekeneya.back.annotations.FieldExist;
import ekeneya.back.services.ITypeStructureService;

/**
 * 
 * @author zakaridia
 *
 */
@Entity
@Table(name = "structure")
public class Structure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3715138725283112414L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="structure_generator")
	@SequenceGenerator(name="structure_generator", sequenceName="structure_sequence")
	@Column(name = "id_structure")
	private Long id;

	@Column(name = "nom_structure", length = 100, nullable = false)
	@Size(min = 3, max = 100, message = "error.structure.name")
	@NotBlank(message="error.structure.name")
	private String name;

	@Column(name = "latitude", nullable = false)
	@NotNull(message = "error.structure.latitude")
	private Double latitude;

	@Column(name = "longitude", nullable = false)
	@NotNull(message = "error.structure.longitude")
	private Double longitude;

	@Column(name = "tel_structure", length = 100, nullable = true)
	@Size(max = 255, message = "error.structure.tel")
	private String tel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ville", nullable = false)
	private Ville ville;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type", nullable = false)
	private TypeStructure type;

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
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * @return the type
	 */
	public TypeStructure getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeStructure type) {
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
