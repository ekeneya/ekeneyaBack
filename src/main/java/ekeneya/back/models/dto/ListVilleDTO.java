package ekeneya.back.models.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zakaridia
 *
 */
public class ListVilleDTO implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8682483339391325073L;
	
	/**
	 * 
	 */
	private List<VilleDTO> villes;


	/**
	 * @return the villes
	 */
	public List<VilleDTO> getVilles() {
		return villes;
	}


	/**
	 * @param villes the villes to set
	 */
	public void setVilles(List<VilleDTO> villes) {
		this.villes = villes;
	}
	
}
