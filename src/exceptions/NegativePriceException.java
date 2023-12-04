package exceptions;

/**
 * This class is used to catch when inputted price is negative
 * 
 * @extends Exception to handle the exception
 */
public class NegativePriceException extends Exception {
	
	/**
	 * This exception is thrown when a negative price is encountered.
	 */
	public NegativePriceException() {
		super("Error: Price Cannot Be Negative! Try Again.");
    }
}


