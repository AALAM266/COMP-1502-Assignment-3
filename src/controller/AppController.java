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
 * It contains methods to add new toys, search for specific toys, remove toys, and save.
 * The main entry point of the application is from the Manager Class super() method, which causes this constructor to be called,
 * loading the data from the file.
 * 
 * @author Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class AppController {

    public String fileName = "res/toys.txt";
    public ArrayList<Toys> toyInventory;
    public ArrayList<Toys> toySearchResults;
    public Toys toyToRemove;
    
	/**
	 * Constructor for the AppController class
	 * @throws Exception 
	 */
    public AppController() throws Exception {
    	toyInventory = new ArrayList<>();
    	
    	loadData();

    }
    
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
	
	public void purchase(Toys currentToy) {
		currentToy.decreaseAvailableCount();
		if (currentToy.getAvailabityCount() == 0) {
			toyInventory.remove(currentToy);
		}
		save();
	}


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
	 * This method is called from the Manager btnRemoveHandler method, it will remove the toy they want using the serial number provided
	 * @param sNumber 
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
	 * @throws Exception
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
	 * @throws Exception
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
