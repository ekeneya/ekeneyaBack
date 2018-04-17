package ekeneya.back.exceptions;

public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3597575197233747730L;
	
	private final String field;
	private final String message;
	private final String messageKey;
	
	public ApiException(String field, String messageKey, String message) {
		super(message);
		this.field = field;
		this.messageKey = messageKey;
		this.message = message;
	}
	
	public ApiException(String field, String messageKey) {
		this(field,messageKey,null);
	}
		

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}


	/**
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApiException [field=" + field + ", message=" + message + ", messageKey=" + messageKey + "]";
	}
	
}
