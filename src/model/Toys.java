package model;

/**
 * This abstract class represents a toy object. It contains the serial number, name, brand, price, availability count, appropriate age range, and type of toy.
 * It also will encapsulate the attributes into one string then properly format it.
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public abstract class Toys {
	
	private String serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availabityCount;
	private int appropriateAge;
	private String toyType;

	/**
	 * Constructor for the Toys class
	 * @param serialNumber serial number of the toy (unique, 10 digits)
	 * @param name name of the toy
	 * @param brand brand of the toy
	 * @param price price of the toy
	 * @param availabityCount how many toys are available in inventory
	 * @param ageAppropriate appropriate age range for the toy
	 * @param toyType type of toy (Puzzle, Board Game, Figure, or Animal)
	 */
	public Toys(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate, String toyType) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availabityCount = availabityCount;
		this.appropriateAge = ageAppropriate;
		this.toyType = toyType;
	}

	/**
	 * Getter method for the serial number
	 * @return the serial number
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Setter method for the serial number
	 * @param serialNumber the serial number to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Getter method for the toy name
	 * @return the toy name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for the toy name
	 * @param name the toy name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the toy brand
	 * @return the toy brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Setter method for the toy brand`
	 * @param brand the toy brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter method for the toy price
	 * @return the toy price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter method for the toy price
	 * @param price the toy price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Getter method for the toy availability count
	 * @return the toy availability count
	 */
	public int getAvailabityCount() {
		return availabityCount;
	}

	/**
	 * Setter method for the toy availability count
	 * @param availabityCount the toy availability to set
	 */
	public void setAvailabityCount(int availabityCount) {
		this.availabityCount = availabityCount;
	}
	
	/**
	 * Decreasing method for the toy availability count
	 */
	public void decreaseAvailableCount() {
			availabityCount -= 1;
		}
	
	/**
	 * Getter method for the age range for the toy
	 * @return the appropriate age range for the toy
	 */
	public int getAppropriateAge() {
		return appropriateAge;
	}

	/**
	 * Setter method for the age range for the toy
	 * @param ageAppropriate the appropriate age range for the toy to set
	 */
	public void setAppropriateAge(int ageAppropriate) {
		this.appropriateAge = ageAppropriate;
	}

	/**
	 * Getter method for the toy type
	 * @return the toy type
	 */
	public String getToyType() {
		return toyType;
	}

	/**
	 * Setter method for the toy type
	 * @param toyType the toy type to set
	 */
	public void setToyType(String toyType) {
		this.toyType = toyType;
	}
	
	/**
	 * This method will return a string representation of the object
	 * @return a string representation of the object
	 */
	public String toString() {
		return ("Category: " + getToyType() + ", Serial Number: " + getSerialNumber() + ", Name: " + getName() + 
				", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailabityCount() + 
				", Age Appropriate: " + getAppropriateAge());
	}


	/**
	* Returns a formatted string containing the serial number, name, brand, price, availability count, and appropriate age range of the toy
	* @return the formatted string
	*/
	public String format() {
			return (getSerialNumber() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getAvailabityCount() + 
					";" + getAppropriateAge());		
	}

	



	
	

}
