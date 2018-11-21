package learn.springboot.exception;

public class AuthenticationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3893540221285034773L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
