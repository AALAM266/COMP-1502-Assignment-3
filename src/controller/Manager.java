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

public class Manager extends AppController implements Initializable {

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
    private ComboBox<String> categoryDropDown;

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
    private ListView<Toys> listViewToyInvHome;

    @FXML
    private ListView<Toys> listViewToyInvRemove;

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
    
    private boolean isValidSerialNumber(String serialNumber) {
        return serialNumber != null
               && serialNumber.length() == 10
               && serialNumber.chars().allMatch(Character::isDigit);
    }
    
    private boolean isValidToyPrice(String price) throws NegativePriceException {
    	boolean isValid = false;
    	double priceValue = Double.parseDouble(price);
    	if (priceValue >= 0) {
            	isValid = true;  	
        }
    	
    	else {
    		throw new NegativePriceException();  
    	}

		return isValid;
    }

    private boolean isValidToyAvailabilityCount(String count) {
        try {
            int countValue = Integer.parseInt(count);
            return countValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidToyAgeRating(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // this should validate any string, checks if its empty and/or case insensitivity (name, brand, board game designer, animal material etc..)
    private boolean isValidString(String str) {
        if (str == null) {
            return false;
        }

        str = str.toLowerCase().trim();
        return !str.isEmpty();
    }

    // this checks the figure class and makes sure it matches the 3 types of figures
    private boolean isValidFigureClassification(String classification) {
        if (classification == null || classification.trim().isEmpty()) {
            return false;
        }
        String lowerCaseClassification = classification.trim().toLowerCase();
        return lowerCaseClassification.equals("action") || lowerCaseClassification.equals("doll") || lowerCaseClassification.equals("historic") ||
        		lowerCaseClassification.equals("a") || lowerCaseClassification.equals("d") || lowerCaseClassification.equals("h");
    }

    // same thing but for puzzle type
    private boolean isValidPuzzleType(String type) {
        if (type == null || type.trim().isEmpty()) {
            return false;
        }
        String lowerCaseType = type.trim().toLowerCase();
        return lowerCaseType.equals("mechanical") || lowerCaseType.equals("cryptic") || lowerCaseType.equals("logic") || lowerCaseType.equals("trivia") || lowerCaseType.equals("riddle") || 
        		lowerCaseType.equals("m") || lowerCaseType.equals("c") || lowerCaseType.equals("l") || lowerCaseType.equals("r");
    }

    // ""
    private boolean isValidAnimalSize(String animalSize) {
        if (animalSize == null || animalSize.trim().isEmpty()) {
            return false;
        }
        String lowerCase = animalSize.trim().toLowerCase();
        return lowerCase.equals("small") || lowerCase.equals("medium") || lowerCase.equals("large") ||
                lowerCase.equals("s") || lowerCase.equals("m") || lowerCase.equals("l");
    }

    // not sure if this works, template i guess
    private boolean isValidMinPlayers(String minPlayers) {
        try {
            int min = Integer.parseInt(minPlayers);
            return min >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // not sure if this works, template i guess
    private boolean isValidMaxPlayers(String maxPlayers, String minPlayers) throws MinMaxException {
    	boolean isValid = false;
    	int max;
        try {
        	 max = Integer.parseInt(maxPlayers);
        } catch (NumberFormatException e) {
            return false;
        }
        
		if (max >= Integer.parseInt(minPlayers) && max >= 0) {
        	isValid = true;  	
        }
     
    	else {
    		throw new MinMaxException();  
    	}

		return isValid;
    }
    
    @FXML
    void btnBuyHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Buy Button Clicked");
    	purchase(currentToy);
    	if (toyInventory.contains(currentToy)) {
    		listViewToyInvHome.getItems().removeAll();
    		ApplicationLogger.logInfo("Purchased " + currentToy.toString());
    		lblErrorHome.setText("Successfully Purchased!");
    	}
    	
    	else {
    		listViewToyInvHome.getItems().removeAll(currentToy);
    		lblErrorHome.setText("Item Does Not Exist!");
    	}
    
    }
    
    @FXML
    void btnSaveHandler(ActionEvent event) throws NegativePriceException, MinMaxException { 
    	ApplicationLogger.logInfo("Save Button Clicked");
    	lblErrorRemove.setText("");
		ApplicationLogger.logInfo("Attempted Saving: " + addtoySnField.getText() + " " + addtoyNameField.getText() + " " + addtoyBrandField.getText() + " " + 
				addtoyPriceField.getText() + " " + addtoyAvailcountField.getText() + " " + addtoyAgeAppField.getText()
				+ " " + figureClassField.getText() + " " + animalMaterialField.getText() + " " + animalSizeField.getText() + " " + puzzleTypeField.getText()
				 + " " + minnumField.getText() + " " + maxnumField.getText() + " " + designersField.getText());
		
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
    	if (isValidSerialNumber(addtoySnField.getText()) && isValidString(addtoyNameField.getText()) 
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
				
				break;
				
			case "animal":
				
				if (isValidString(animalMaterialField.getText()) && isValidAnimalSize(animalSizeField.getText())) {
					
					String newToy = addNewAnimal(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), 
							addtoyAgeAppField.getText(), animalMaterialField.getText(), animalSizeField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
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
				
				break;

				
			case "boardgame":
				
				if (isValidMinPlayers(minnumField.getText()) && isValidMaxPlayers(maxnumField.getText(), minnumField.getText()) && isValidString(designersField.getText())) {
					
					String newToy = addNewBoardGame(addtoySnField.getText(), addtoyNameField.getText(), addtoyBrandField.getText(),
							addtoyPriceField.getText(), addtoyAvailcountField.getText(), addtoyAgeAppField.getText(), minnumField.getText(), 
							maxnumField.getText(), designersField.getText());
					lblErrorAdd.setText("Successfully Added!");
					ApplicationLogger.logInfo("Added: " + newToy);
				}
	
				break;
			}
    		
    	}
    	
    	
    }	
    
    @FXML
    void btnRemoveHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Remove Button Clicked");
    	lblErrorRemove.setText("");
		ApplicationLogger.logInfo("Searched: " + txtFieldSNRemove.getText());
    	if (isValidSerialNumber(txtFieldSNRemove.getText())) {
    		if (removeToy(txtFieldSNRemove.getText())) {
    			lblErrorRemove.setText("Successfully Removed!");
    			ApplicationLogger.logInfo("Removed: " + txtFieldSNRemove.getText());
    			listViewToyInvRemove.getItems().removeAll(toyToRemove);
    		}
    		
    		else {
    			lblErrorRemove.setText("Serial Number Does Not Exist!");
    		}
    	}
    	
    	else {
			lblErrorRemove.setText("Invalid Input! Try again.");
		}
    	
    }
    
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
			}
			
		}
    }
    
    @FXML void btnClearHandler(ActionEvent event) { 
    	ApplicationLogger.logInfo("Clear Button Clicked");
    	txtFieldSNSearch.clear(); 
    	txtFieldNameSearch.clear(); 
    	txtFieldTypeSearch.clear(); 
    	listViewToyInvHome.getItems().clear(); 
    }

    @FXML
    void btnNameHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Name Button Clicked");
    	btnSN.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(false);
    	txtFieldTypeSearch.setDisable(true);
    }

    @FXML
    void btnSNHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Serial Number Button Clicked");
    	btnName.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(false);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(true);
    }

    @FXML
    void btnTypeHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Type Button Clicked");
    	btnSN.setSelected(false);
    	btnName.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(false);
    }

    @FXML
    void btnGetResultsHandler(ActionEvent event) {
    	ApplicationLogger.logInfo("Refresh Button Clicked");
    	listViewToyInvRemove.getItems().removeAll(toyInventory);
    	listViewToyInvRemove.getItems().addAll(toyInventory);
    }
    
    @FXML
    void catergoryDropDownHandler(ActionEvent event) {
    	
    	switch (categoryDropDown.getValue().trim().toLowerCase()) {
		case "figure":
			figureClassField.setDisable(false);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			puzzleTypeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			break;
			
		case "animal":
			animalMaterialField.setDisable(false);
			animalSizeField.setDisable(false);
			figureClassField.setDisable(true);
			puzzleTypeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			break;
			
		case "puzzle":
			puzzleTypeField.setDisable(false);
			figureClassField.setDisable(true);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			minnumField.setDisable(true);
			maxnumField.setDisable(true);
			designersField.setDisable(true);
			break;

			
		case "boardgame":
			minnumField.setDisable(false);
			maxnumField.setDisable(false);
			designersField.setDisable(false);
			figureClassField.setDisable(true);
			animalMaterialField.setDisable(true);
			animalSizeField.setDisable(true);
			puzzleTypeField.setDisable(true);

			break;
		}
    }

}
