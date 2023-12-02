package view;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.NegativePriceException;
import model.Toys;

/**
 * This class contains the main menu for the application as well as the multiple sub menus that will be used to prompt the user for
 * various inputs based on their choice (with proper validation). It also contains the methods that will be used to display the results of the user's choice.
 * Most methods will be called from the AppController class.
 * @authors Akheel Alam Eddin and Keegan Hong 
 * @version 1.0
 */
public class AppMenu {
	
private Scanner input; // Scanner object to get the user input
	
	/**
	 * This constructor will initialize the scanner object
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Shows the welcome message to the user
	 */
	public void showWelcomeMsg() {
		System.out.println("******************************************************");
		System.out.println("*        WELCOME TO TOY STORE COMPANY!               *");
		System.out.println("******************************************************");
		System.out.println();
	}
		
	/**
	 * Shows the main menu to the user and prompts the user for their input
	 */
	public void showMainMenu() { 
		System.out.println("How May We Help You?");
		System.out.println();
		System.out.println("\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Make a Gift Suggestion");
		System.out.println("\t(5) Save & Exit");
		System.out.println();
	}
		
	/**
	 * Prompts the user to choose an option from the main menu
	 * @return the option chosen by the user
	 */
	public int enterOption() {
		System.out.print("Enter Option: ");
		int choice = -1;
		if (input.hasNextInt()) {
			choice = input.nextInt();
			input.nextLine();  
		} else {
			System.out.println();
			System.out.println("This is not an Integer Number! Try again.");
			System.out.println();
			input.nextLine();  
			return enterOption();  
		}
		
		if (choice < 0 || choice > 5) {
			System.out.println();
			System.out.println("This is not a valid option! Try again.");
			System.out.println();
			return enterOption(); 
		}
		System.out.println();
		return choice;
	}		
	
	/**
	 * Prompts the user to choose an option from the search menu
	 * @return the option chosen by the user
	 */
	public int enterOption2() {
		System.out.print("Enter Option: ");
		int choice = -1;
		if (input.hasNextInt()) {
			choice = input.nextInt();
			input.nextLine();  
		} else {
			System.out.println();
			System.out.println("This is not an Integer Number! Try again.");
			System.out.println();
			input.nextLine();  
			return enterOption();  
		}
		
		if (choice < 0 || choice > 4) {
			System.out.println();
			System.out.println("This is not a valid option! Try again.");
			System.out.println();
			return enterOption(); 
		}
		System.out.println();
		return choice;
	}		
	
	/**
	 * Shows the search menu to the user and prompts the user for the input
	 */
	public void showSearchMenu() { 
		System.out.println("Find Toys With:");
		System.out.println();
		System.out.println("\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.println();
	}
	
	/**
	 * Prompts the user for the serial number for when they want to add a toy
	 * @param toyInventory arraylist containing the inventory
	 * @return the serial number for the toy
	 */
	public String promptSN(ArrayList<Toys> toyInventory) { 
		System.out.print("Enter Serial Number (SN): ");
		String serialNumber = "0";
		Long serialNumber1;
		
		if (input.hasNextLong()) {
			serialNumber1 = Long.parseLong(input.nextLine().trim().toLowerCase());
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN(toyInventory);  
		}
		
		if (String.valueOf(serialNumber1).length() != 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			return promptSN(toyInventory);  
		}
		
		serialNumber = String.valueOf(serialNumber1);
	
		for (Toys t : toyInventory) {
			if (serialNumber.equals(t.getSerialNumber())) {
				System.out.println();
				System.out.println("A Toy With This Serial Number Already Exists! Try Again.");
				System.out.println();
				return promptSN(toyInventory);  
			}	
		}	
		System.out.println();
		return serialNumber;
	}

	
	/**
	 * Prompts the user for the toy name for searching, purchasing, or adding purposes
	 * @return the name of the toy
	 */
	public String promptToyName() { 
		String name;
		while (true) {
			System.out.print("Enter Toy Name: ");
			name = input.nextLine().trim().toLowerCase();
	
			if (name == null || name.isEmpty()) {
				System.out.println("Toy Name Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return name;
	}

	/**
	 * Prompts the user for the toy type for searching, purchasing, or adding purposes
	 * @return the type of toy (puzzle, boardgame, figure, or animal)
	 */
	public String promptType() { 
		String type;
		while (true) {
			System.out.print("Enter Toy Type: ");
			type = input.nextLine().trim().toLowerCase();
	
			if (type == null || type.isEmpty()) {
				System.out.println("Toy Type Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return type;
	}
	
	/**
	 * Prompts the user for the toy type when looking for gift suggestions
	 * @return the type of toy (puzzle, boardgame, figure, or animal)
	 */
	public String promptGiftType() { 
		String type;
		System.out.print("Enter Toy Type, Or Hit ENTER To Skip: ");
		type = input.nextLine().trim().toLowerCase();
		System.out.println();
		return type;
	}
	
	/**
	 * Prompts the user for the toy brand when adding a toy
	 * @return the brand of the toy
	 */
	public String promptBrand() { 
		String brand;
		while (true) {
			System.out.print("Enter Brand Name: ");
			brand = input.nextLine().trim().toLowerCase();
	
			if (brand == null || brand.isEmpty()) {
				System.out.println("Brand Name Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return brand;
	}
	
	
	/**
	 * Prompts the user for the price of the toy when adding a toy
	 * @return the price of the toy (with two decimal places (double))
	 */
	public double promptToyPrice() throws NegativePriceException {
		double price = -1;
		while (true) {
			System.out.print("Enter Toy Price: ");
			if (input.hasNextDouble()) {
				price = input.nextDouble();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			try {
				if (!(price < 0)) {
					break;
				} 
				
				else {
					throw new NegativePriceException();
				}
				
			} catch (Exception e) {
				System.out.println();
				e.printStackTrace();
				System.out.println();
				continue;	
			}
			
		}
		System.out.println();
		return price;
	}
	
	/**
	 * Prompts the user for the minimum price of the toy when looking for gift suggestions
	 * @return the price of the toy (displayed as a range of (price-price2))
	 */
	public double promptToyPriceMin() { 
		double price = -1;
		String choice;
		while (true) {
			
			System.out.print("Enter Minimum Toy Price, Or Hit ENTER To Skip: ");
			choice = input.nextLine();
			if (choice.isEmpty()) {
				System.out.println();
				return price;
			}
			else {
				try {
					price = Integer.parseInt(choice);
					if (price < 0) {
						System.out.println();
						System.out.println("Minimum Price Cannot Be Negative! Try Again.");
						System.out.println();
						continue;  
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println();
					System.out.println("Not an Integer Number! Try again.");
					System.out.println();
					continue;  
				}
		}
		}
		System.out.println();
		return price;
	}
	
	/**
	 * Prompts the user for the maximum price of the toy when looking for gift suggestions
	 * @param price the minimum price of the toy
	 * @return the maximum price of the toy (displayed as a range of (price-price2))
	 */
	public double promptToyPriceMax(Double price) { 
		double price2 = -1;
		String choice;
		while (true) {
			System.out.print("Enter Maximum Toy Price, Or Hit ENTER To Skip: ");
			choice = input.nextLine();
			if (choice.isEmpty()) {
				System.out.println();
				return price2;
			}
			else {
				try {
					price2 = Integer.parseInt(choice);
					if (price2 < 0) {
						System.out.println();
						System.out.println("Maximum Price Cannot Be Negative! Try Again.");
						System.out.println();
						continue;  
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println();
					System.out.println("Not an Integer Number! Try again.");
					System.out.println();
					continue;  
				}
		}
		}
		System.out.println();
		return price2;
	}
	
	/**
	 * Prompts the user for the availability count when adding a toy
	 * @return how many toys will be available in inventory
	 */
	public int promptAvailableCount() { 
		int availableCount = -1;
		while (true) {
			System.out.print("Enter Available Count: ");
			if (input.hasNextInt()) {
				availableCount = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (availableCount <= 0) {
				System.out.println();
				System.out.println("Available Count Cannot Be Negative Or Zero! Try Again.");
				System.out.println(); 
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return availableCount;
	}
	
	/**
	 * Prompts the user for the age rating when adding a toy
	 * @return the age rating for the toy
	 */
	public int promptAgeAppropriate() {
		int appropriateAge = -1;
		while (true) {
			System.out.print("Enter Appropriate Age: ");
			if (input.hasNextInt()) {
				appropriateAge = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (appropriateAge < 0) {
				System.out.println();
				System.out.println("Appropriate Age Cannot Be Negative! Try Again.");
				System.out.println();
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return appropriateAge;
	}
	
	/**
	 * Prompts the user for the age rating when looking for gift suggestions
	 * @return the age rating for the toy
	 */
	public int promptGiftAgeAppropriate() {
		int appropriateAge = -1;
		String choice;
		while (true) {
			System.out.print("Enter Appropriate Age, Or Hit ENTER To Skip: ");
			choice = input.nextLine();
			if (choice.isEmpty()) {
				System.out.println();
				return appropriateAge;
			}
			else {
				try {
					appropriateAge = Integer.parseInt(choice);
					if (appropriateAge < 0) {
						System.out.println();
						System.out.println("Appropriate Age Cannot Be Negative! Try Again.");
						System.out.println();
						continue;  
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println();
					System.out.println("Not an Integer Number! Try again.");
					System.out.println();
					continue;  
				}
			}
		}
		System.out.println();
		return appropriateAge;
	}
	
	/**
	 * Prompts the user for the minimum ammount of players (only if the user is adding a boardgame)
	 * @return the minimum player count (will be displayed as min-max)
	 */
	public int promptMinPlayers() { 
		int minPlayers = -1;
		while (true) {
			System.out.print("Enter Minimum Number of Players: ");
			if (input.hasNextInt()) {
				minPlayers = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (minPlayers < 0) {
				System.out.println();
				System.out.println("Minimum Number of Players Cannot Be Negative! Try Again.");
				System.out.println();
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return minPlayers;
	}
	
	/**
	 * Prompts the user for the maximum amount of players (only if the user is adding a boardgame)
	 * @return the maximum player count (will be displayed as min-max)
	 */
	public int promptMaxPlayers() { 
		int maxPlayers = -1;
		while (true) {
			System.out.print("Enter Maximum Number of Players: ");
			if (input.hasNextInt()) {
				maxPlayers = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (maxPlayers < 0) {
				System.out.println();
				System.out.println("Maximum Number of Players Cannot Be Negative! Try Again.");
				System.out.println();
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return maxPlayers;
	}
	
	/**
	 * Prompts the user for the designer(s) name of the toy (only if the user is adding a boardgame)
	 * @return the designer name
	 */
	public String promptDesigners() {
		String designers;
		while (true) {
			System.out.print("Enter Designer Names (Use ',' to separate the names if there is more than one name): ");
			designers = input.nextLine().trim().toLowerCase();
	
			if (designers == null || designers.isEmpty()) {
				System.out.println("Designers Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return designers;
	}
	

	/**
	 * Displays the total number of toys in the inventory and a message telling the user that search results will be displayed
	 * @param toyInventory arraylist containing the inventory
	 */
	public void showSearchResultsP1(ArrayList<Toys> toyInventory) {
		System.out.println("Number of toys in inventory: " + toyInventory.size());
		System.out.println();
		System.out.println("Here are the search results:");
		System.out.println();
	}
	
	/**
	 * Displays the search results to the user (part 2)
	 * @param t the toy search results
	 * @param n user choice number
	 */
	public void showSearchResultsP2(Toys t, int n) {
		System.out.println("\t(" + n + ") " + t);
	}
	
	/**
	 * Displays the search results to the user (part 3)
	 * @param n user choice number
	 * @return the user's choice (which toy they want to purchase or go back to the main menu)
	 */
	public int showSearchResultsP3(int n) {
		int mainChoice = -1;
		System.out.println("\t(" + n + ") Back to Main Menu");
		System.out.println();
		
		while (true) {
			System.out.print("Enter option number to purchase: ");
			if (input.hasNextInt()) {
				mainChoice = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (mainChoice <= 0) {
				System.out.println();
				System.out.println("Choice Cannot Be Negative or Zero! Try Again.");
				System.out.println();
				continue;  
			} 
			
			if (mainChoice > n) {
				System.out.println();
				System.out.println("Choice Out of Range! Try Again.");
				System.out.println(); 
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return mainChoice;
	}

	
	/**
	 * Shows the user that their transaction has been successfully termianted
	 */
	public void showTransactionSuccess() {
		System.out.println("The Transaction Successfully Terminated!");
		System.out.println();
	}
	
	/**
	 * Shows the user a message that the toy has been added successfully
	 */
	public void showAddNewToySuccess() {
		System.out.println("New Toy Added!");
		System.out.println();
	}
	
	/**
	 * Shows the user a message that the toy has been removed successfully
	 */
	public void showRemoveToySuccess() {
		System.out.println("Item Removed!");
		System.out.println();
	}
	
	/**
	 * Prompts the user to hit enter to continue
	 */
	public void promptPressEnter(){
		System.out.println("Press \"ENTER\" to continue...");
		input.nextLine();
		System.out.println();
	}


	/**
	 * Informs the user that they entered an invalid choice
	 */
	public void showInvalidChoice() {
		System.out.println("Invalid choice");
		System.out.println();
	}
	
	/**
	 * Displays a saving message to the user when exiting the application
	 */
	public void showSavingMsg() {
		System.out.println();
		System.out.println("Saving Data Into Database...");
		System.out.println();
		System.out.println();
		System.out.println("*********** THANKS FOR VISITING US! ***********");
	}
	
	/**
	 * Shows the user the toy they are about to remove with a confirmation (Y/N)
	 * @param t the toy that will be removed
	 * @return the user's choice (Y/N)
	 */
	public char promptRemoveToy(Toys t) {
		System.out.print("This Item Found: ");
		System.out.println();
		System.out.println("\t" + t);
		System.out.println();
		System.out.print("Do you want to remove it (Y/N)? ");
		char removeChoice = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		return removeChoice;	
	}
	

	/**
	 * Prompts the user to decide whether to remove the toy.
	 * @return the user's choice (Y/N)
	 */
	public char promptRemoveToyAgain() {
		System.out.print("Do you want to remove it (Y/N)? ");
		char removeChoice = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		return removeChoice;	
	}


	/**
	 * Prompts the user for the serial number (only if adding searching, buying or removing)
	 * @return the serial number of the toy
	 */
	public String promptSN() {
		System.out.print("Enter Serial Number (SN): ");
		String serialNumber = "0";
		Long serialNumber1;
		
		if (input.hasNextLong()) {
			serialNumber1 = Long.parseLong(input.nextLine().trim().toLowerCase());
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN();  
		}
		
		if (String.valueOf(serialNumber1).length() != 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			return promptSN();  
		}
		serialNumber = String.valueOf(serialNumber1);
		System.out.println();
		return serialNumber;
	}
	
	/**
	 * Prompts the user for the serial number (only if adding searching, buying or removing)
	 * @return the serial number of the toy
	 */
	public String promptSN(String sNumber) {
		System.out.print("Enter Serial Number (SN): ");
		String serialNumber = "0";
		Long serialNumber1;
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (input.hasNextLong()) {
			serialNumber1 = Long.parseLong(input.nextLine().trim().toLowerCase());
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN();  
		}
		
		if (String.valueOf(serialNumber1).length() != 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			return promptSN();  
		}
		serialNumber = String.valueOf(serialNumber1);
		System.out.println();
		return serialNumber;
	}


	/**
	 * Prompts the user for the classification (only if adding a figure)
	 * @return the classification of the figure (Action (a), Doll (d), or Historic (h))
	 */
	public String promptClassification() {
		String classification;
		while (true) {
			System.out.print("Enter Classification (A/D/H): ");
			classification = input.nextLine().trim().toLowerCase();
	
			if (classification == null || classification.isEmpty()) {
				System.out.println("Classification Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return classification;
	}

	/**
	 * Prompts the user for the type of the puzzle (only if adding a puzzle)
	 * @return the puzzle type (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r))
	 */
	public String promptPuzzleType() {
		String puzzleType;
		while (true) {
			System.out.print("Enter Puzzle Type (M/C/L/T/R): ");
			puzzleType = input.nextLine().trim().toLowerCase();
	
			if (puzzleType == null || puzzleType.isEmpty()) {
				System.out.println("Puzzle Type Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return puzzleType;
	}

	/**
	 * Prompts the user for the material (only if adding an animal)
	 * @return the material of the animal toy
	 */
	public String promptMaterial() {
		String material;
		while (true) {
			System.out.print("Enter Material: ");
			material = input.nextLine().trim().toLowerCase();
	
			if (material == null || material.isEmpty()) {
				System.out.println("Material Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return material;
	}

	/**
	 * Prompts the user for the size (only if adding an animal)
	 * @return the size of the animal toy (Small (s), Medium (m), or Large (l))
	 */
	public String promptSize() {
		String size;
		while (true) {
			System.out.print("Enter Size (S/M/L): ");
			size = input.nextLine().trim().toLowerCase();
	
			if (size == null || size.isEmpty()) {
				System.out.println("Size Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return size;
	}

	/**
	 * Informs the user that they entered a missing serial number
	 */
	public void showSerialNumberNotFound() {
		System.out.println("No Matches Found! Try Again.");
		System.out.println();
	}
	
	/**
	 * Informs the user that they entered a missing toy name
	 */
	public void showToyNameNotFound() {
		System.out.println("No Matches Found! Try Again.");
		System.out.println();
	}

	/**
	 * Informs the user that they entered a missing toy type
	 */
	public void showToyTypeNotFound() {
		System.out.println("No Matches Found! Try Again.");
		System.out.println();
	}

	/**
	 * Informs the user that they entered 3 blank inputs
	 */
	public void showRetryGiftSuggestion() {
		System.out.println("All 3 Fields Cannot Be Blank! Try Again.");
		System.out.println();
		
	}

	/**
	 * Informs the user that they entered a minimum price that is greater than the maximum price
	 */
	public void showGiftPriceError() {
		System.out.println("Minimum price cannot be greater than the maximum price!");
		System.out.println("Please enter the values again: ");
		System.out.println();
	}

}
