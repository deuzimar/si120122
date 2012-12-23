package exception;

public class InvalidLinkException extends Exception {
	private static final long serialVersionUID = -8556683553389658017L;

	public InvalidLinkException(String message){
		super(message);
	}
}
