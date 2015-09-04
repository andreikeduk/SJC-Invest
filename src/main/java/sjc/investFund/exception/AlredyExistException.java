package sjc.investFund.exception;

public class AlredyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMsg() {
		return message;
	}

	public void setMsg(String message) {
		this.message = message;
	}

	public AlredyExistException(String message) {
		this.message = message;
	}
	
}
