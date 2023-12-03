package model;

/**
 * This subclass represents a board game object. It contains the basic toy attributes, minimum and maximum number of players, and designer(s) names
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class BoardGames extends Toys {

    private int minPlayers;
    private int maxPlayers;
    private String designers;
    
	/**
	 * Constructor for the BoardGames class
	 * @param serialNumber serial number of the board game (unique, 10 digits that starts with either 7, 8, or 9)
	 * @param name name of the board game
	 * @param brand brand of the board game
	 * @param price price of the board game
	 * @param availabityCount how many board games are available in inventory
	 * @param ageAppropriate appropriate age range for the board game
	 * @param toyType board game
	 * @param minPlayers minimum number of players the board game can have (displayed as min-max)
	 * @param maxPlayers maximum number of players the board game can have (displayed as min-max)
	 * @param designers designer(s) names of the board game
	 */
	public BoardGames(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, int minPlayers, int maxPlayers, String designers) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
	}

	/**
	 * Getter method for the minimum number of players
	 * @return the minimum number of players the board game can have
	 */
	public int getMinPlayers() {
		return minPlayers;
	}

	/**
	 * Setter method for the minimum number of players
	 * @param minPlayers the minimum number of players to set
	 */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	/**
	 * Getter method for the maximum number of players
	 * @return the maximum number of players the board game can have
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * Setter method for the maximum number of players
	 * @param maxPlayers the maximum number of players to set
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	/**
	 * Getter method for the designer(s) of the board game
	 * @return the designer(s) names of the board game
	 */
	public String getDesigners() {
		return designers;
	}

	/**
	 * Setter method for the designer(s) of the board game
	 * @param designers the designer(s) names to set
	 */
	public void setDesigners(String designers) {
		this.designers = designers;
	}
    
	/**
 	* This method will return string representation of the boardgame object
 	* @return a string representation of the boardgame object, including the minimum and maximum number of players as well as the designer(s) names
 	*/
	@Override
	public String toString() {
    	return super.toString() + ", Number of Players: " + getMinPlayers() + "-" + getMaxPlayers() + ", Designer(s): " + getDesigners();
    }
	

	/**
	 * This method will return a formatted string representation of the board game's minimum and maximum number of players and designer(s) names
	 * @return formatted string representation of the board game's minimum and maximum number of players and designer(s) names
	 */
	@Override
	public String format() {
			return super.format() + ";" + getMinPlayers() + "-" + getMaxPlayers() + ";" + getDesigners() + "\n";		
	}

}
