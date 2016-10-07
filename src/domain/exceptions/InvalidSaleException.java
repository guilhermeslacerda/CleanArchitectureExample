package domain.exceptions;

public class InvalidSaleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidSaleException(String message) {
		super(message);
	}
}
