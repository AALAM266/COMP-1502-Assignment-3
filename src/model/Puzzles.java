package model;

/**
 * This subclass represents a puzzle object. It contains the basic toy attributes and puzzle type.
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class Puzzles extends Toys {

    private String puzzleType;

	/**
	 * Constructor for the Puzzles class
	 * @param serialNumber serial number of the puzzle toy (unique, 10 digits that starts with either 4, 5, or 6)
	 * @param name name of the puzzle toy
	 * @param brand brand of the puzzle toy
	 * @param price price of the puzzle toy
	 * @param availabityCount how many puzzle toys are available in inventory
	 * @param ageAppropriate appropriate age range for the puzzle toy
	 * @param toyType puzzle
	 * @param puzzleType type of puzzle (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r))
	 */
	public Puzzles(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String puzzleType) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.puzzleType = puzzleType;
	}

	/**
	 * Getter method for the puzzle type
	 * @return the puzzle type (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r))
	 */
	public String getPuzzleType() {
		return puzzleType;
	}

	/**
	 * Setter method for the puzzle type
	 * @param puzzleType the puzzle type to set
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}


	/**
 	* This method will return string representation of the object.
 	* @return a string representation of the object, including the puzzle type (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r))
 	*/
	@Override
    public String toString() {
    	return super.toString() + ", Puzzle Type: " + getPuzzleType();
    }
    
    /**
	 * This method will return a formatted string representation of the puzzle's type
	 * @return formatted string representation of the puzzle's type
	 */
	@Override
	public String format() {
			return super.format() + ";" + getPuzzleType() + "\n";		
	}

}
