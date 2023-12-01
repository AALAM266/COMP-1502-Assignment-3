package exceptions;

/**
 * @exception MixMaxException Class to catch when the minimum number of players is greater than the maximum
 */
public class MinMaxException extends Exception {
	
	/**
	 * Constructor
	 */
	public MinMaxException() {
		super("Error: Minimum Players Cannot Be Greater Than The Maximum! Try Again.");
    }

}
