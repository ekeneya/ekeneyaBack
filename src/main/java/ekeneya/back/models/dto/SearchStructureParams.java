package ekeneya.back.models.dto;

public class SearchStructureParams {

	private Integer page;
	private Integer size;
	private String codeVille;
	private String codeType;
	private String name;
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	
	/**
	 * @return the codeVille
	 */
	public String getCodeVille() {
		return codeVille;
	}
	/**
	 * @param codeVille the codeVille to set
	 */
	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}
	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
