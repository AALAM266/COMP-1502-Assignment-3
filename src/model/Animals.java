package model;

/**
 * This subclass represents an animal toy object. It contains the basic toy attributes, material, and size of the animal toy
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class Animals extends Toys {

    private String material;
    private String size;
    
	/**
	 * Constructor for the Animals class
	 * @param serialNumber serial number of the animal toy (unique, 10 digits that starts with either 2, or 3)
	 * @param name name of the animal toy
	 * @param brand brand of the animal toy
	 * @param price price of the animal toy
	 * @param availabityCount how many animal toys are available in inventory
	 * @param ageAppropriate appropriate age range for the animal toy
	 * @param toyType animal
	 * @param material material of the animal toy 
	 * @param size size of the animal toy (Small (s), Medium (m), or Large (l))
	 */
	public Animals(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String material, String size) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.material = material;
		this.size = size;
	}

	/**
	 * Getter method for the animal material
	 * @return the animal material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Setter method for the animal material
	 * @param material the animal material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Getter method for the animal size
	 * @return the animal size (Small (s), Medium (m), or Large (l))
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Setter method for the animal size
	 * @param size the animal size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
 	* This method will return string representation of the animal object.
 	* @return a string representation of the animal object, including the material and size
 	*/
	@Override
	public String toString() {
    	return super.toString() + ", Material: " + getMaterial() + ", Size: " + getSize();
    }

	
	/**
	 * This method will return a formatted string representation of the animal's material and size.
	 * @return formatted string representation of the animal's material and size
	 */
	@Override
	public String format() {
			return super.format() + ";" + getMaterial() + ";" + getSize() + "\n";			
	}
}
