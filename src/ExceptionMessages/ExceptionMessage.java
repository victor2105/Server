package ExceptionMessages;

public class ExceptionMessage  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7730894177370826830L;
	String message;
	
	public ExceptionMessage(String msg) {
		// TODO Auto-generated constructor stub
		message = "{ \"error\": \"" + msg + "\" }";
	}
	
	public ExceptionMessage() {
		// TODO Auto-generated constructor stub
		message = "{ \"error\": \"error\" }";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
	
}
