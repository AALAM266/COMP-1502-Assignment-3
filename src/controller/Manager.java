package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import model.Toys;

/**
 * This class is the controller for the ToyStoreApp.fxml file. It handles and initializes all the events and actions that occur in the GUI, including buttons, textfields, and dropdown menus.
 * It also handles the exceptions that are thrown when invalid input is entered into the textfields.
 * 
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class Manager extends AppController implements Initializable {

	/**
	 * This is the constructor for the Manager class. It calls the super constructor from the AppController class.
	 * @throws Exception incase of an error
	 */
    public Manager() throws Exception {
		super();
	}

	@FXML
    private TextField addtoyAgeAppField;

    @FXML
    private TextField addtoyAvailcountField;

    @FXML
    private TextField addtoyBrandField;

    @FXML
    private TextField addtoyNameField;

    @FXML
    private TextField addtoyPriceField;

    @FXML
    private TextField addtoySnField;

    @FXML
    private TextField animalMaterialField;

    @FXML
    private TextField animalSizeField;

    @FXML
    private Button btnBuy;

    @FXML
    private Button btnClear;
    
    @FXML
    private Button btnGetResults;

    @FXML
    private RadioButton btnName;

    @FXML
    private Button btnRemove;

    @FXML
    private RadioButton btnSN;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private RadioButton btnType;

    @FXML
	public ComboBox<String> categoryDropDown;

    @FXML
    private TextField designersField;

    @FXML
    private TextField figureClassField;

    @FXML
    private Label lblErrorAdd;

    @FXML
    private Label lblErrorHome;

    @FXML
    private Label lblErrorRemove;
    
    @FXML
    private Label lblName;

    @FXML
    private Label lblSN;

    @FXML
    private Label lblSNRemove;

    @FXML
    private Label lblType;

    @FXML
	public ListView<Toys> listViewToyInvHome;

    @FXML
	public ListView<Toys> listViewToyInvRemove;

    @FXML
    private TextField maxnumField;

    @FXML
    private TextField minnumField;

    @FXML
    private TextField puzzleTypeField;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField txtFieldNameSearch; 

    @FXML
    private TextField txtFieldSNRemove;

    @FXML
    private TextField txtFieldSNSearch;

    @FXML
    private TextField txtFieldTypeSearch;
    
    public Toys currentToy;
    
	/**
	 * This method initializes the GUI and sets the items in the dropdown menu and the listviews.
	 * @param arg0 the URL
	 * @param arg1 the ResourceBundle
	 */
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		categoryDropDown.setItems(FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "BoardGame"));
		listViewToyInvRemove.getItems().addAll(toyInventory);
    	listViewToyInvHome.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Toys>() {

			@Override
			public void changed(ObservableValue<? extends Toys> arg0, Toys arg1, Toys arg2) {
				currentToy = listViewToyInvHome.getSelectionModel().getSelectedItem();
			}
				
		}); 
    	
    	listViewToyInvRemove.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Toys>() {

			@Override
			public void changed(ObservableValue<? extends Toys> arg0, Toys arg1, Toys arg2) {
				currentToy = listViewToyInvRemove.getSelectionModel().getSelectedItem();
				
			}
    	});
	}
    
	/**
	 * This method checks the serial number and validates it in case the user enters an invalid serial number or one that already exists.
	 * @param serialNumber the serial number to validate
	 * @return true if the serial number is valid, false otherwise
	 */
    public boolean isValidNewSerialNumber(String serialNumber) {
    	
		if (serialNumber != null) {
			for (Toys t : toyInventory) {
				if (serialNumber.equals(t.getSerialNumber())) {
					return false;
				}
			}
		}
		
        return serialNumber != null
               && serialNumber.length() == 10
               && serialNumber.chars().allMatch(Character::isDigit);
    }
    
    /**
	 * This method checks the serial number and validates it in case the user enters an invalid serial number.
	 * @param serialNumber the serial number to validate
	 * @return true if the serial number is valid, false otherwise
	 */
    public boolean isValidSerialNumber(String serialNumber) {

        return serialNumber != null
               && serialNumber.length() == 10
               && serialNumber.chars().allMatch(Character::isDigit);
    }
    
	/**
	 * This method checks the price and validates it incase the user enters an invalid price.
	 * @param price the price to validate
	 * @return true if the price is valid, false otherwise
	 * @throws NegativePriceException incase the price is negative
	 */
    public boolean isValidToyPrice(String price) throws NegativePriceException {
        double priceValue;
        try {
            priceValue = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return false;
        }
        
        if (priceValue >= 0) {
            return true;
        } else {
            throw new NegativePriceException();
        }
    }

	/**
	 * This method checks the availability count and validates it incase the user enters an invalid availability count.
	 * @param count the availability count to validate
	 * @return true if the availability count is valid, false otherwise
	 */
    public boolean isValidToyAvailabilityCount(String count) {
        try {
            int countValue = Integer.parseInt(count);
            return countValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	/**
	 * This method checks the age rating and validates it incase the user enters an invalid age rating.
	 * @param age the age rating to validate
	 * @return true if the age rating is valid, false otherwise
	 */
    public boolean isValidToyAgeRating(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	/**
	 * This method checks user input for name, brand, animal material, and board game designers and validates it incase the user enters an invalid input.
	 * @param str the user input to validate
	 * @return true if the user input is valid, false otherwise
	 */
    public boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

	/**
	 * This method checks the figure classification (Action (a), Doll (d), or Historic (h)) and validates it incase the user enters an invalid figure classification.
	 * @param classification the figure classification to validate
	 * @return true if the figure classification is valid, false otherwise
	 */
    public boolean isValidFigureClassification(String classification) {
        if (classification == null || classification.trim().isEmpty()) {
            return false;
        }
        String lowerCaseClassification = classification.trim().toLowerCase();
        return lowerCaseClassification.equals("action") || lowerCaseClassification.equals("doll") || lowerCaseClassification.equals("historic") ||
        		lowerCaseClassification.equals("a") || lowerCaseClassification.equals("d") || lowerCaseClassification.equals("h");
    }

	/**
	 * This method checks the puzzle type (Mechanical (m), Cryptic (c), Logic (l), Trivia (t), or Riddle (r)) and validates it incase the user enters an invalid puzzle type.
	 * @param type the puzzle type to validate
	 * @return true if the puzzle type is valid, false otherwise
	 */
    public boolean isValidPuzzleType(String type) {
        if (type == null || type.trim().isEmpty()) {
            return false;
        }
        String lowerCaseType = type.trim().toLowerCase();
        return lowerCaseType.equals("mechanical") || lowerCaseType.equals("cryptic") || lowerCaseType.equals("logic") || lowerCaseType.equals("trivia") || lowerCaseType.equals("riddle") || 
        		lowerCaseType.equals("m") || lowerCaseType.equals("c") || lowerCaseType.equals("l") || lowerCaseType.equals("r");
    }

	/**
	 * This method checks the animal material (Small (s), Medium (m), or Large (l)) and validates it incase the user enters an invalid animal material.
	 * @param animalSize the animal material to validate
	 * @return true if the animal material is valid, false otherwise
	 */
    public boolean isValidAnimalSize(String animalSize) {
        if (animalSize == null || animalSize.trim().isEmpty()) {
            return false;
        }
        String lowerCase = animalSize.trim().toLowerCase();
        return lowerCase.equals("small") || lowerCase.equals("medium") || lowerCase.equals("large") ||
                lowerCase.equals("s") || lowerCase.equals("m") || lowerCase.equals("l");
    }

	/**
	 * This method checks the minimum number of players and validates it incase the user enters an invalid minimum number of players.
	 * @param minPlayers the minimum number of players to validate
	 * @return true if the minimum number of players is valid, false otherwise
	 */
    public boolean isValidMinPlayers(String minPlayers) {
        try {
            int min = Integer.parseInt(minPlayers);
            return min >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	/**
	 * This method checks the maximum number of players and validates it incase the user enters an invalid maximum number of players.
	 * @param maxPlayers the maximum number of players to validate
	 * @param minPlayers the minimum number of players to validate
	 * @return true if the maximum number of players is valid, false otherwise
	 * @throws MinMaxException incase the minimum number of players is larger than the maximum number of players
	 */
    public boolean isValidMaxPlayers(String maxPlayers, String minPlayers) throws MinMaxException {
        int max, min;
        try {
            max = Integer.parseInt(maxPlayers);
            min = Integer.parseInt(minPlayers);
        } catch (NumberFormatException e) {
            return false;  
        }
        
        if (max < 0) {
            return false; 
        }

        if (max < min) {
            throw new MinMaxException();
        }
        return true;
    }
    
    
	/**
	 * This method handles the buy button in the home screen when the user is searching for a toy they want to purchase
	 * @param event the event that occurs when the buy button is clicked
	 */
    @FXML
    void btnBuyHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Buy Button Clicked");
    	
    	if (currentToy != null) {
    		purchase(currentToy);
    	}
    	
    	if (toyInventory.contains(currentToy)) {
    		listViewToyInvHome.getItems().removeAll();
    		ApplicationLogger.logInfo("Purchased " + currentToy.toString());
    		lblErrorHome.setText("Successfully Purchased!");
    	}
    	
    	else {
    		listViewToyInvHome.getItems().removeAll(currentToy);
    		lblErrorHome.setText("Item Does Not Exist!");
    		ApplicationLogger.logWarning("Attempted To Purchase Item Not Found");
    	}
    
    }
    
	/**
	 * This method handles the save button in the add toy screen when the user is adding a new toy to the inventory
	 * @param event the event that occurs when the save button is clicked
	 * @throws NegativePriceException incase the price is negative
	 * @throws MinMaxException incase the minimum number of players is larger than the maximum number of players
	 */
    @FXML
    void btnSaveHandler(ActionEvent event) throws NegativePriceException, MinMaxException { 
    	ApplicationLogger.logInfo("Save Button Clicked");
    	lblErrorRemove.setText("");
		ApplicationLogger.logInfo("Attempted Saving: " + addtoySnField.getText() + " " + addtoyNameField.getText() + " " + addtoyBrandField.getText() + " " + 
				addtoyPriceField.getText() + " " + addtoyAvailcountField.getText() + " " + addtoyAgeAppField.getText()
				+ " " + figureClassField.getText() + " " + animalMaterialField.getText() + " " + animalSizeField.getText() + " " + puzzleTypeField.getText()
				 + " " + minnumField.getText() + " " + maxnumField.getText() + " " + designersField.getText());
		
    	if (isValidNewSerialNumber(addtoySnField.getText()) && isValidString(addtoyNameField.getText()) 
    			&& isValidString(addtoyBrandField.getText()) && isValidToyPrice(addtoyPriceField.getText()) 
    			&& isValidToyAvailabilityCount(addtoyAvailcountField.getText()) && isValidToyAgeRating(addtoyAgeAppField.getText())){
    		
    		switch (categoryDropDown.getValue().trim().toLowerCase()) {
			case "figure":
				if (isValidFigureClassification(figureClassField.getText())) {
					
					String newToy = addNewFigure(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), 
							addtoyAgeAppField.getText(), figureClassField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
				}
				
				else {
		    		lblErrorAdd.setText("Invalid Input! Try again.");
		    		ApplicationLogger.logWarning("Failed To Add Toy");
		    	}
				
				break;
				
			case "animal":
				
				if (isValidString(animalMaterialField.getText()) && isValidAnimalSize(animalSizeField.getText())) {
					
					String newToy = addNewAnimal(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), 
							addtoyAgeAppField.getText(), animalMaterialField.getText(), animalSizeField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
				}
				
				else {
		    		lblErrorAdd.setText("Invalid Input! Try again.");
		    		ApplicationLogger.logWarning("Failed To Add Toy");
		    	}
				
				break;
				
			case "puzzle":
				
				if (isValidPuzzleType(puzzleTypeField.getText())) {
					
					String newToy = addNewPuzzle(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), 
							addtoyAgeAppField.getText(), puzzleTypeField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
				}
				
				else {
		    		lblErrorAdd.setText("Invalid Input! Try again.");
		    		ApplicationLogger.logWarning("Failed To Add Toy");
		    	}
				
				break;

				
			case "boardgame":
				
				if (isValidMinPlayers(minnumField.getText()) && isValidMaxPlayers(maxnumField.getText(), minnumField.getText()) && isValidString(designersField.getText())) {
					
					String newToy = addNewBoardGame(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), addtoyAgeAppField.getText(), minnumField.getText(), 
							maxnumField.getText(), designersField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
				}
				
				else {
		    		lblErrorAdd.setText("Invalid Input! Try again.");
		    		ApplicationLogger.logWarning("Failed To Add Toy");
		    	}
	
				break;
			}
    		
    	}
    	
    	else {
    		lblErrorAdd.setText("Invalid Input! Try again.");
    		ApplicationLogger.logWarning("Failed To Add Toy");
    	}
    	
    }	
    
	/**
	 * This method handles the remove button in the remove toy screen when the user is removing a toy from the inventory
	 * @param event the event that occurs when the remove button is clicked
	 */
    @FXML
    void btnRemoveHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Remove Button Clicked");
    	lblErrorRemove.setText("");
		ApplicationLogger.logInfo("Searched: " + txtFieldSNRemove.getText());
		
		if (removeToy(txtFieldSNRemove.getText())) {
			lblErrorRemove.setText("Successfully Removed!");
			ApplicationLogger.logInfo("Removed: " + txtFieldSNRemove.getText());
			listViewToyInvRemove.getItems().removeAll(toyToRemove);
		}
		
		else {
			lblErrorRemove.setText("Serial Number Does Not Exist!");
			ApplicationLogger.logWarning("Attempted To Remove Item Not Found");
		}
	
    }
    
	/**
	 * This method handles the search button in the home screen when the user is searching for a toy
	 * @param event the event that occurs when the search button is clicked
	 */
    @FXML
    void btnSearchHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Search Button Clicked");
		if (btnSN.isSelected()) {
			lblErrorHome.setText("");
			listViewToyInvHome.getItems().removeAll(toyInventory);
			ApplicationLogger.logInfo("Searched: " + txtFieldSNSearch.getText());
			if (isValidSerialNumber(txtFieldSNSearch.getText())) {
				listViewToyInvHome.getItems().addAll(search(1, txtFieldSNSearch.getText()));
			}
			else {
				lblErrorHome.setText("Invalid Input! Try again.");
				ApplicationLogger.logWarning("Searched With Invalid Input");
			}
				
		}
		
		else if (btnName.isSelected()) { 
			lblErrorHome.setText("");
			listViewToyInvHome.getItems().removeAll(toyInventory);
			ApplicationLogger.logInfo("Searched: " + txtFieldNameSearch.getText());
			if (isValidString(txtFieldNameSearch.getText())) {
				listViewToyInvHome.getItems().addAll(search(2, txtFieldNameSearch.getText()));
			}
			else {
				lblErrorHome.setText("Invalid Input! Try again.");
				ApplicationLogger.logWarning("Searched With Invalid Input");
			}
	
		}
		
		else if (btnType.isSelected()) {
			lblErrorHome.setText("");
			listViewToyInvHome.getItems().removeAll(toyInventory);
			ApplicationLogger.logInfo("Searched: " + txtFieldTypeSearch.getText());
			if (isValidString(txtFieldTypeSearch.getText())) {
				listViewToyInvHome.getItems().addAll(search(3, txtFieldTypeSearch.getText()));
			}
			else {
				lblErrorHome.setText("Invalid Input! Try again.");
				ApplicationLogger.logWarning("Searched With Invalid Input");
			}
			
		}
    }
    
	/**
	 * This method handles the clear button in the home screen when the user is searching for a toy
	 * @param event the event that occurs when the clear button is clicked
	 */
    @FXML void btnClearHandler(ActionEvent event) { 
    	ApplicationLogger.logInfo("Clear Button Clicked");
    	txtFieldSNSearch.clear(); 
    	txtFieldNameSearch.clear(); 
    	txtFieldTypeSearch.clear(); 
    	listViewToyInvHome.getItems().clear(); 
    }

	/**
	 * This method handles the name radio button when the user wants to search by name
	 * @param event the event that occurs when the name radio button is clicked
	 */
    @FXML
    void btnNameHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Name Button Clicked");
    	btnSN.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(false);
    	txtFieldTypeSearch.setDisable(true);
    }

	/**
	 * This method handles the serial number radio button when the user wants to search by serial number
	 * @param event the event that occurs when the serial number radio button is clicked
	 */
    @FXML
    void btnSNHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Serial Number Button Clicked");
    	btnName.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(false);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(true);
    }

	/**
	 * This method handles the type radio button when the user wants to search by type
	 * @param event the event that occurs when the type radio button is clicked
	 */
    @FXML
    void btnTypeHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Type Button Clicked");
    	btnSN.setSelected(false);
    	btnName.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(false);
    }

	/**
	 * This method handles the refresh button in the remove toy screen when the user wants to refresh the listview
	 * @param event the event that occurs when the refresh button is clicked
	 */
    @FXML
    void btnGetResultsHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Refresh Button Clicked");
    	listViewToyInvRemove.getItems().clear(); 
    	listViewToyInvRemove.getItems().addAll(toyInventory);
    }
    
	/**
	 * This method handles the dropdown menu when the user wants to select the type of toy to add to the inventory
	 * @param event the event that occurs when the dropdown menu is clicked
	 */
    @FXML
    void catergoryDropDownHandler(ActionEvent event) {
  
    	switch (categoryDropDown.getValue().trim().toLowerCase()) {
		case "figure":
			ApplicationLogger.logInfo("Drop Down Menu Switched To " + categoryDropDown.getValue().trim());
			figureClassField.setDisable(false);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			puzzleTypeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			
			animalMaterialField.clear(); 
			animalSizeField.clear(); 
			puzzleTypeField.clear(); 
			minnumField.clear(); 
			maxnumField.clear(); 
			designersField.clear(); 
			break;
			
		case "animal":
			ApplicationLogger.logInfo("Drop Down Menu Switched To " + categoryDropDown.getValue().trim());
			animalMaterialField.setDisable(false);
			animalSizeField.setDisable(false);
			figureClassField.setDisable(true);
			puzzleTypeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			
			figureClassField.clear(); 
			puzzleTypeField.clear(); 
			minnumField.clear(); 
			maxnumField.clear(); 
			designersField.clear(); 
			break;
			
		case "puzzle":
			ApplicationLogger.logInfo("Drop Down Menu Switched To " + categoryDropDown.getValue().trim());
			puzzleTypeField.setDisable(false);
			figureClassField.setDisable(true);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			
			figureClassField.clear(); 
			animalMaterialField.clear(); 
			animalSizeField.clear(); 
			minnumField.clear(); 
			maxnumField.clear(); 
			designersField.clear(); 
			break;

			
		case "boardgame":
			ApplicationLogger.logInfo("Drop Down Menu Switched To " + categoryDropDown.getValue().trim());
			minnumField.setDisable(false);
			maxnumField.setDisable(false);
			designersField.setDisable(false);
			figureClassField.setDisable(true);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			puzzleTypeField.setDisable(true);

			figureClassField.clear(); 
			animalMaterialField.clear(); 
			animalSizeField.clear(); 
			puzzleTypeField.clear(); 
			break;
		}
    }

}
