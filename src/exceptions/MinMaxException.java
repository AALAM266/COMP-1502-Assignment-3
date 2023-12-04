package exceptions;

/**
 * This class is used to catch when the minimum number of players is greater than the maximum
 * 
 * @extends Exception to handle the exception
 */
public class MinMaxException extends Exception {
	
	/**
	 * This exception is thrown when the minimum number of players is greater than the maximum
	 */
	public MinMaxException() {
		super("Error: Minimum Players Cannot Be Greater Than The Maximum! Try Again.");
    }

}
