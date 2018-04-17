package ekeneya.back.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * @author zakaridia
 *
 */
@Entity
@Table(name="type_structure")
public class TypeStructure implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2475092418669009566L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="type_structure_generator")
	@SequenceGenerator(name="type_structure_generator", sequenceName="type_structure_sequence")
	@Column(name = "id_type_structure")
	private Long id;
		
	@Column(name = "libelle_type_structure", length = 30, nullable = false, unique=true)
	@Size(min = 3, max = 30, message = "error.type_structure.libelle")
	private String libelle;
	
	@Column(name="code_type_structure", nullable = false)
	private String code;
	
	public TypeStructure(){
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeStructure [id=" + id + ", libelle=" + libelle + ", code=" + code + "]";
	}
	
	
}
