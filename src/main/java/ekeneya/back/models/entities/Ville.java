package ekeneya.back.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author zakaridia
 *
 */
@Entity
@Table(name="ville")
public class Ville implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4880414508654350152L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ville_generator")
	@SequenceGenerator(name="ville_generator", sequenceName="ville_sequence")
	@Column(name = "id_ville")
	private Long id;
		
	@Column(name = "libelle_ville", length = 30, nullable = false)
	@Size(min = 3, max = 30, message = "error.ville.libelle")
	private String libelle;
	
	@Column(name="code_ville", nullable = false, unique=true)
	private String code;
	
	@Column(name="latitude", nullable = false)
	@NotNull(message = "error.structure.latitude")
	private Double latitude;
	

	@Column(name="longitude", nullable = false)
	@NotNull(message = "error.structure.longitude")
	private Double longitude;
	
	public Ville(){
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
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
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ville [id=" + id + ", libelle=" + libelle + ", code=" + code + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
