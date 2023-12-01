package model;

/**
 * This subclass represents a Figure object. It contains the basic toy attributes and the figure classification
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class Figures extends Toys {

    private String classification;
	
    /**
	 * Constructor for the Figures class
	 * @param serialNumber serial number of the figure toy (unique, 10 digits that starts with either 0, or 1)
	 * @param name name of the figure toy
	 * @param brand brand of the figure toy
	 * @param price price of the figure toy 
	 * @param availabityCount how many figure toys are available in inventory
	 * @param ageAppropriate appropriate age range for the figure toy
	 * @param toyType figure
	 * @param classification figure classification (Action (a), Doll (d), or Historic (h))
	 */
	public Figures(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String classification) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.classification = classification;
	}

	/**
	 * Getter method for the figure classification
	 * @return the figure classification (Action (a), Doll (d), or Historic (h))
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Setter method for the figure classification
	 * @param classification the figure classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
 	* This method will return string representation of the figure object.
 	* @return a string representation of the object, including the figure classification
 	*/
	@Override
	public String toString() {
    	return super.toString() + ", Classification: " + getClassification();
    }

	 /**
	 * This method will return a formatted string representation of the figure's classification
	 * @return formatted string representation of the figure's classification
	 */
	@Override
	public String format() {
		return super.format() + ";" + getClassification() + "\n";	
	}

}
