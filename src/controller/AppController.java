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
import view.AppMenu;

/**
 * The AppController class is responsible for managing the application, it interacts with the user through the AppMenu.
 * It contains methods to add new toys, search for specific toys, remove toys, and a gift suggestion.
 * The main entry point of the application is the launchApplication() method, which
 * displays the main menu to the user and calls the appropriate methods based on the
 * user's choice.
 * 
 * @author Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class AppController {

    private final String FILENAME = "res/toys.txt";
    private AppMenu appMenu;
    public ArrayList<Toys> toyInventory;
    public ArrayList<Toys> toySearchResults;
    public Toys toyToRemove;
    
	/**
	 * Constructor for the AppController class
	 * @throws Exception 
	 */
    public AppController() throws Exception {
    	toyInventory = new ArrayList<>();
    	appMenu = new AppMenu();
    	
    	loadData();
    	
    	//launchApplication();
    }
    
    /**
	 * This method is called from the constructor and will show the main menu to the
	 * user and then call the appropriate method based on the user's choice
	 * 
	 * @throws Exception
	 */
//	public void launchApplication() throws Exception { 
//		boolean flag = true;
//		int option;
//		appMenu.showWelcomeMsg();
//
//		while (flag) {
//			appMenu.showMainMenu();
//			option = appMenu.enterOption();
//
//			switch (option) {
//
//			case 1:
//				searchAndPurchase();
//				break;
//			case 2:
//				addNewToy();
//				break;
//			case 3:
//				removeToy();
//				break;
//			case 4:
//				makeGiftSuggestion();
//				break;
//			case 5:
//				save();
//				flag = false;
//				break;
//			default:
//				appMenu.showInvalidChoice();
//			}
//		}
//
//	}

	/**
	 * This method is called from the launchApplication method, it will search for toys based on the user input and allow the user to purchase them
	 * @param sNumber 
	 * @return 
	 */
	public ArrayList<Toys> search(int option, String specifier) {

			boolean flag2 = true;
			toySearchResults = new ArrayList<>();
			int n = 1;
			int choice = -1;
			Toys t1 = null;
			
			switch (option) {

			case 1:
				String serialNumber = specifier;
				
				boolean toyFound = false;
				for (Toys t : toyInventory) {
					
					if (serialNumber.equalsIgnoreCase(t.getSerialNumber())) {
						toySearchResults.add(t);
						n += 1;
						t1 = t;
						toyFound = true;
					}				
				}
				
				return toySearchResults;
			
			case 2:
				String name = specifier;
				
				toyFound = false;
				for (Toys t : toyInventory) {
					
					if (t.getName().toLowerCase().contains(name.toLowerCase())) {
						appMenu.showSearchResultsP2(t, n);
						toySearchResults.add(t);
						n += 1;
						t1 = t;
						toyFound = true;
					}
					
				}
				
				return toySearchResults;
			case 3:
				String type = specifier;
		
				for (Toys t : toyInventory) {
					
					if (type.equalsIgnoreCase(t.getToyType())) {
						appMenu.showSearchResultsP2(t, n);
						toySearchResults.add(t);
						t1 = t;
						n += 1;
						toyFound = true;
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

	/**
	 * This method is called from the launchApplication method, it will prompt the user for all of the toy's attributes then it
	 * will add it to the arraylist that will eventually get stored in the txt file
	 * @param string7 
	 * @param string6 
	 * @param string5 
	 * @param string4 
	 * @param string3 
	 * @param string2 
	 * @param serialNumber 
	 * @throws NegativePriceException 
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
	
	public void addNewToy(String sNumber, String name, String brand1, String price1, String availableCount1, String appropriateAge1, String type1) throws NegativePriceException, MinMaxException {
		boolean flag3 = true;
		
		String serialNumber = appMenu.promptSN(toyInventory, sNumber);
		String name1 = appMenu.promptToyName();
		String brand = appMenu.promptBrand();
		
		double price = appMenu.promptToyPrice();
		int availableCount = appMenu.promptAvailableCount();
		int appropriateAge = appMenu.promptAgeAppropriate();
		
		while (flag3) {
			Toys t;
			switch (appMenu.promptType()) {
			case "boardgame":
				
				int minPlayers = appMenu.promptMinPlayers();
				int maxPlayers = appMenu.promptMaxPlayers();
				while (minPlayers > maxPlayers) {
					try {
						throw new MinMaxException();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println();
					}
					
					minPlayers = appMenu.promptMinPlayers();
					maxPlayers = appMenu.promptMaxPlayers();
				break;
				}
				
				String designers = appMenu.promptDesigners();
				
				t = new BoardGames(serialNumber, name1, brand, price, availableCount, 
						appropriateAge, "BoardGame", minPlayers, maxPlayers, designers);
				toyInventory.add(t);
				flag3 = false;
				break;
				
			case "figure":
				boolean flag = true;
				String classification = null;
				while (flag ) {
					classification = appMenu.promptClassification();
					switch (classification) {
					case "a":
					case "d":
					case "h":
						flag = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				
				t = new Figures(serialNumber, name1, brand, price, availableCount, 
						appropriateAge, "figure", classification);
				toyInventory.add(t);
				
				flag3 = false;
				break;
				
			case "animal":
				boolean flag1 = true;
				String material = appMenu.promptMaterial();
				String size = null;
				while (flag1) {				
					size = appMenu.promptSize();
					switch (size) {
					case "s":
					case "m":
					case "l":
						flag1 = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				t = new Animals(serialNumber, name1, brand, price, availableCount, 
						appropriateAge, "animal", material, size);
				toyInventory.add(t);
				
				flag3 = false;
				break;
				
			case "puzzle":
				boolean flag2 = true;
				String puzzleType = null;
				while (flag2) {		
					puzzleType = appMenu.promptPuzzleType();
					switch (puzzleType) {
					case "m":
					case "c":
					case "l":
					case "t":
					case "r":
						flag2 = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				t = new Puzzles(serialNumber, name1, brand, price, availableCount, 
						appropriateAge, "puzzle", puzzleType);
				toyInventory.add(t);
				
				flag3 = false;
				break;
			default:
				appMenu.showInvalidChoice();
			}
		}

		appMenu.showAddNewToySuccess();
		appMenu.promptPressEnter();
		
	}
	
	/**
	 * This method is called from the launchApplication method, it will prompt the user for the serial number of the toy they want to remove
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
	 * This method is called from the launchApplication method, it will prompt the user for either the age rating of the toy, or the type, or the price range
	 * The information will then be used to recommend a gift for the user to buy
	 */
	public void makeGiftSuggestion() {
		final double MAX_PRICE = 1000000;
		int giftCounter = 0;
		int n = 1;
		int choice = -1;
		String type = null;
		int appropriateAge = appMenu.promptGiftAgeAppropriate();
		if (appropriateAge != -1) {
			giftCounter += 1;
		}
		boolean flag1 = true;
		boolean flag2 = true;
		while (flag1) {		
			type = appMenu.promptGiftType();
			switch (type) {
			case "boardgame":
			case "animal":
			case "figure":
			case "puzzle":
				giftCounter += 1;
				flag1 = false;
				break;
			
			case "":
				flag1 = false;
				break;

			default:
				
				appMenu.showInvalidChoice();
			}
		}

		Double price = appMenu.promptToyPriceMin();
		Double price2 = appMenu.promptToyPriceMax(price);
		while(price > price2 && price2 != -1) {
			appMenu.showGiftPriceError();
			price = appMenu.promptToyPriceMin();
			price2 = appMenu.promptToyPriceMax(price);
		}
		
		if (price > price2 && price2 == -1) {
			price2 = MAX_PRICE;
		}
		
		if (price != -1 || price2 != -1) {
			giftCounter += 1;
		}
		
		if (giftCounter == 0) {
			appMenu.showRetryGiftSuggestion();
			makeGiftSuggestion();
		}
		
		appMenu.showSearchResultsP1(toyInventory);
		ArrayList<Toys> toySearchResults = new ArrayList<>();
		appMenu.showSearchResultsP1(toyInventory);
		Toys t1 = null;
		for (Toys t : toyInventory) {
			
			if (type.equalsIgnoreCase(t.getToyType())) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
			
			if (t.getAppropriateAge() >= appropriateAge && appropriateAge != -1) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
			
			if (t.getPrice() >= price && t.getPrice() <= price2) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
		}	

		while (flag2) {
			choice = appMenu.showSearchResultsP3(n);
			
			if (choice == n) {
				flag2 = false;
				break;
			}
			
			else if (choice > n || choice < 1) {
				appMenu.showInvalidChoice();
			}
			
			else {
				toySearchResults.remove(choice - 1);
				
				t1.decreaseAvailableCount();
				toyInventory.remove(choice);
				appMenu.showTransactionSuccess();
				appMenu.promptPressEnter();
			}
			
		}
	}

	/**
	 * This method is called from the launchApplication method, it will save the
	 * data into the txt file when the program is shut down
	 * @throws Exception
	 */
	public void save() { // Save data into the txt file when the user chooses the save and exit option
		try(FileWriter fw = new FileWriter(FILENAME, false)) {

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
	//	appMenu.showSavingMsg();
	} catch (IOException e) {
		e.printStackTrace();
		
	}

	}
	
	/**
	 * This method is called from the constructor, it will load the data from the
	 * txt resource file into the arraylist to be used as the inventory for the application
	 * @throws Exception
	 */
	private void loadData() throws Exception { 
		File toyInventoryInfo = new File(FILENAME);
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
				
				else if (splittedLine.length == 8 && splittedLine[7].length() == 1) {
					
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
