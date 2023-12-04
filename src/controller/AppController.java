package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;

/**
 * The AppController class is responsible for managing the application, it interacts with the user through the Manager Class.
 * It contains methods to add new toys, search for specific toys, remove toys, and saving.
 * The main entry point of the application is from the Manager Class super() method, which causes this constructor to be called,
 * loading the data from the file.
 * 
 * @author Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class AppController {

    public String fileName = "res/toys.txt"; // File name of the txt file
    public ArrayList<Toys> toyInventory; // Arraylist of toys
    public ArrayList<Toys> toySearchResults; // Arraylist of toys that match the search criteria
    public Toys toyToRemove; // Toy to be removed
    
	/**
	 * Constructor for the AppController class
	 * @throws Exception in case of an error
	 */
    public AppController() throws Exception {
    	toyInventory = new ArrayList<>();
    	
    	loadData();

    }
    
	/**
	 * This method is called from the Manager btnSearchHandler method, it will search for the toy they want using the option and specifier provided
	 * @param option 
	 * @param specifier
	 * @return the requested search results 
	 */
	public ArrayList<Toys> search(int option, String specifier) {

			toySearchResults = new ArrayList<>();
			Toys t1 = null;
			
			switch (option) {

			case 1:
				String serialNumber = specifier;
				
				for (Toys t : toyInventory) {
					
					if (serialNumber.equalsIgnoreCase(t.getSerialNumber())) {
						toySearchResults.add(t);
						t1 = t;
					}				
				}
				
				return toySearchResults;
			
			case 2:
				String name = specifier;
				
				for (Toys t : toyInventory) {
					
					if (t.getName().toLowerCase().contains(name.toLowerCase())) {
						toySearchResults.add(t);
						t1 = t;
					}
					
				}
				
				return toySearchResults;
			case 3:
				String type = specifier;
		
				for (Toys t : toyInventory) {
					
					if (type.equalsIgnoreCase(t.getToyType())) {
						toySearchResults.add(t);
						t1 = t;
					}
				}
		
				return toySearchResults;
			}
			
		return toyInventory;
	
	}
	
	/**
	 * This method is called from the Manager btnBuyHandler method, it will purchase the requested toy and subtract the available count by 1
	 * @param currentToy the toy to be purchased
	 */
	public void purchase(Toys currentToy) {
		currentToy.decreaseAvailableCount();
		if (currentToy.getAvailabityCount() == 0) {
			toyInventory.remove(currentToy);
		}
		save();
	}

	/**
	 * This method will add a new toy the user wants using the information provided (only if the user wants to add a figure)
	 * @param sNumber serial number of the toy
	 * @param name1 name of the toy
	 * @param brand1 brand of the toy
	 * @param price1 price of the toy
	 * @param availableCount1 available count of the toy
	 * @param appropriateAge1 appropriate age rating of the toy
	 * @param classification1 classification of the figure (Action (a), Doll (d), or Historic (h)
	 * @return the figure that the user added
	 * @throws NegativePriceException if the user enters a negative number for the price 
	 * @throws MinMaxException if the user enters a minimum player count that is larger than the maximum player count
	 */
	public String addNewFigure(String sNumber, String name1, String brand1, String price1, String availableCount1, 
			String appropriateAge1, String classification1) throws NegativePriceException, MinMaxException {
		
		String serialNumber = sNumber;
		String name = name1;
		String brand = brand1;
		
		double price = Double.parseDouble(price1);
		int availableCount = Integer.parseInt(availableCount1);
		int appropriateAge = Integer.parseInt(appropriateAge1);
		
		Toys t;
		String classification = classification1.substring(0, 1);
		
		t = new Figures(serialNumber, name, brand, price, availableCount, 
					appropriateAge, "figure", classification);
		toyInventory.add(t);
		save();
		return t.format();
			
	}
	
	/**
	 * This method will add a new toy the user wants using the information provided (only if the user wants to add an animal)
	 * @param sNumber serial number of the toy
	 * @param name1 name of the toy
	 * @param brand1 brand of the toy
	 * @param price1 price of the toy 
	 * @param availableCount1 available count of the toy
	 * @param appropriateAge1 appropriate age rating of the toy 
	 * @param material material of the toy
	 * @param size1 size of the toy (Small(s), Medium(m), Large(l))
	 * @return the animal that the user added
	 * @throws NegativePriceException if the user enters a negative number for the price
	 * @throws MinMaxException if the user enters a minimum player count that is larger than the maximum player count
	 */
	public String addNewAnimal(String sNumber, String name1, String brand1, String price1, String availableCount1, 
			String appropriateAge1, String material, String size1) throws NegativePriceException, MinMaxException {
		
		String serialNumber = sNumber;
		String name = name1;
		String brand = brand1;
		
		double price = Double.parseDouble(price1);
		int availableCount = Integer.parseInt(availableCount1);
		int appropriateAge = Integer.parseInt(appropriateAge1);
		
		Toys t;
		String size = size1.substring(0, 1);
		
		t = new Animals(serialNumber, name, brand, price, availableCount, 
				appropriateAge, "animal", material, size);
		toyInventory.add(t);
		save();
		return t.format();
	}
	
	/**
	 * This method will add a new toy the user wants using the information provided (only if the user wants to add a puzzle)
	 * @param sNumber serial number of the toy
	 * @param name1 name of the toy
	 * @param brand1 brand of the toy
	 * @param price1 price of the toy
	 * @param availableCount1 available count of the toy
	 * @param appropriateAge1 appropriate age rating of the toy
	 * @param puzzleType1 type of puzzle (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r))
	 * @return the puzzle that the user added
	 * @throws NegativePriceException if the user enters a negative number for the price
	 * @throws MinMaxException if the user enters a minimum player count that is larger than the maximum player count
	 */
	public String addNewPuzzle(String sNumber, String name1, String brand1, String price1, String availableCount1, 
			String appropriateAge1, String puzzleType1) throws NegativePriceException, MinMaxException {
		
		String serialNumber = sNumber;
		String name = name1;
		String brand = brand1;
		
		double price = Double.parseDouble(price1);
		int availableCount = Integer.parseInt(availableCount1);
		int appropriateAge = Integer.parseInt(appropriateAge1);
		
		Toys t;
		String puzzleType = puzzleType1.substring(0, 1);
		
		t = new Puzzles(serialNumber, name, brand, price, availableCount, 
				appropriateAge, "puzzle", puzzleType);
		toyInventory.add(t);
		save();
		return t.format();
	}
	
	/**
	 * This method will add a new toy the user wants using the information provided (only if the user wants to add a board game)
	 * @param sNumber serial number of the toy
	 * @param name1 name of the toy
	 * @param brand1 brand of the toy
	 * @param price1 price of the toy
	 * @param availableCount1 available count of the toy
	 * @param appropriateAge1 appropriate age rating of the toy
	 * @param minPlayers1 minimum player count of the board game
	 * @param maxPlayers1 maximum player count of the board game
	 * @param designers designers of the board game (separated by commas if more than 1)
	 * @return the board game that the user added
	 * @throws NegativePriceException if the user enters a negative number for the price
	 * @throws MinMaxException if the user enters a minimum player count that is larger than the maximum player count
	 */
	public String addNewBoardGame(String sNumber, String name1, String brand1, String price1, String availableCount1, 
			String appropriateAge1, String minPlayers1, String maxPlayers1, String designers) throws NegativePriceException, MinMaxException {
		
		String serialNumber = sNumber;
		String name = name1;
		String brand = brand1;
		
		double price = Double.parseDouble(price1);
		int availableCount = Integer.parseInt(availableCount1);
		int appropriateAge = Integer.parseInt(appropriateAge1);
		
		Toys t;
		int minPlayers = Integer.parseInt(minPlayers1);
		int maxPlayers = Integer.parseInt(maxPlayers1);
		
		t = new BoardGames(serialNumber, name, brand, price, availableCount, 
				appropriateAge, "boardgame", minPlayers, maxPlayers, designers);
		toyInventory.add(t);
		save();
		return t.format();
	}
	
	/**
	 * This method will remove the toy the user wants by using the serial number they provided
	 * @param sNumber serial number of the toy
	 */
	public boolean removeToy(String sNumber) {
		String serialNumber = sNumber;
		boolean toyRemoval = false;
		Toys t1 = null;
		for (Toys t : toyInventory) {
			if (serialNumber.equals(t.getSerialNumber())) {
						t1 = t;
						toyToRemove = t;
						toyRemoval = true;
					}
				}		
	
		if (toyRemoval == true) {
			toyInventory.remove(t1);
			save();
			return true;
		}

		return false;
	}
	

	/**
	 * This method is called from the purchase, addNewFigure, addNewAnimal, addNewPuzzle, addNewBoardGame, and removeToy methods, it will save the
	 * data into the txt file when the program is shut down
	 * @throws Exception in case of an error
	 */
	public void save() { // Save data into the txt file when the user changes the inventory
		try(FileWriter fw = new FileWriter(fileName, false)) {

			for (Toys t : toyInventory) {
				
				if (t.getToyType().toLowerCase().equals("boardgame")) {
					BoardGames b = (BoardGames) t; 
					fw.write(b.format());
				}
				else if (t.getToyType().toLowerCase().equals("figure")) {
					Figures f = (Figures) t; 
					fw.write(f.format());
				}
				else if (t.getToyType().toLowerCase().equals("animal")) {
					Animals a = (Animals) t; 
					fw.write(a.format());
				}
				else {
					Puzzles p = (Puzzles) t; 
					fw.write(p.format());
				}
			}	

		} catch (IOException e) {
		e.printStackTrace();
		
		}

	}
	
	/**
	 * This method is called from the constructor, it will load the data from the
	 * txt resource file into the arraylist to be used as the inventory for the application
	 * @throws Exception in case of an error
	 */
	public void loadData() throws Exception { 
		File toyInventoryInfo = new File(fileName);
		String currentLine;
		String[] splittedLine;

		if (toyInventoryInfo.exists()) { // checks if the file exists
			Scanner fileReader = new Scanner(toyInventoryInfo);

			while (fileReader.hasNextLine()) { // reads the file line by line

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				
				if (splittedLine[6].length() == 1 && splittedLine[6].toLowerCase().charAt(0) != 'a' 
						&& splittedLine[6].toLowerCase().charAt(0) != 'd' && splittedLine[6].toLowerCase().charAt(0) != 'h') {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'm':
					case 'c':
					case 'l':
					case 't':
					case 'r':
						
						Toys t = new Puzzles(splittedLine[0], splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Puzzle", splittedLine[6].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else if (splittedLine.length == 8 && splittedLine[7].length() == 1 && !(splittedLine[6].contains("-"))) {
					
					Toys t = new Animals(splittedLine[0], splittedLine[1].toLowerCase(), 
							splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
							Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
							"Animal", splittedLine[6].toLowerCase(), splittedLine[7].toLowerCase());
					toyInventory.add(t);
					
				}
				
				else if (splittedLine[6].length() == 1) {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'a':
					case 'd':
					case 'h':
						
						Toys t = new Figures(splittedLine[0], splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Figure", splittedLine[6].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else {
					String[] numberOfPlayers = splittedLine[6].split("-");
					Toys t = new BoardGames(splittedLine[0], splittedLine[1].toLowerCase(), 
							splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
							Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
							"BoardGame", Integer.parseInt(numberOfPlayers[0]), Integer.parseInt(numberOfPlayers[1]), 
							splittedLine[7].toLowerCase());
					toyInventory.add(t);
				}
			}

			fileReader.close();
		}
	}

	

    
}
