package ekeneya.back.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ApiExceptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5485695536100788409L;
	
	private final List<ApiException> exceptions = new ArrayList<>();
	
	/**
	 * 
	 * @param exception
	 */
	public void addException(ApiException exception){
		this.exceptions.add(exception);
	}

	/**
	 * @return the exceptions
	 */
	public List<ApiException> getExceptions() {
		return exceptions;
	}	
	
}
