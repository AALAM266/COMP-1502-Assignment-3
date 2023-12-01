package exceptions;

public class NegativePriceException extends Exception {
	
	/**
	 * Constructor
	 */
	public NegativePriceException() {
		super("Error: Price Cannot Be Negative! Try Again.");
    }
}


