package controller;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Tab;
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
    private Label lblError;
    
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
    private Tab tabAddToy;

    @FXML
    private Tab tabHome;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabRemove;

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
		categoryDropDown.setItems(FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "Board Game"));
		listViewToyInvHome.getItems().addAll(toyInventory);
    	listViewToyInvHome.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Toys>() {

			@Override
			public void changed(ObservableValue<? extends Toys> arg0, Toys arg1, Toys arg2) {
				currentToy = listViewToyInvHome.getSelectionModel().getSelectedItem();
			}
				
		}); 
		
	}
    
    @FXML
    void btnBuyHandler(ActionEvent event) {
    	purchase(currentToy);
    	if (toyInventory.contains(currentToy)) {
    		listViewToyInvHome.getItems().removeAll();
    		listViewToyInvHome.getItems().addAll(toyInventory);
    	}
    	
    	else {
    		listViewToyInvHome.getItems().removeAll(currentToy);
    		listViewToyInvHome.getItems().addAll(toyInventory);
    	}
    
    }
    
    @FXML
    void btnRemoveHandler(ActionEvent event) {
    	removeToy(txtFieldSNRemove.getText());
    }
    
    @FXML
    void btnSearchHandler(ActionEvent event) {
		if (btnSN.isSelected()) {
			search(1,txtFieldSNSearch.getText());
			listViewToyInvHome.getItems().addAll(toySearchResults);
		}
		
		else if (btnName.isSelected()) { 
			search(2, txtFieldNameSearch.getText());
			listViewToyInvHome.getItems().addAll(toySearchResults);
		}
		
		else if (btnType.isSelected()) {
			search(3, txtFieldTypeSearch.getText());
			listViewToyInvHome.getItems().addAll(toySearchResults);
		}
    }
    
    @FXML void btnClearHandler(ActionEvent event) { 
    	txtFieldSNSearch.clear(); 
    	txtFieldNameSearch.clear(); 
    	txtFieldTypeSearch.clear(); 
    	listViewToyInvHome.getItems().clear(); 
    }

    @FXML
    void btnNameHandlerr(ActionEvent event) {
    	btnSN.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(false);
    	txtFieldTypeSearch.setDisable(true);
    }

    @FXML
    void btnSNHandler(ActionEvent event) {
    	btnName.setSelected(false);
    	btnType.setSelected(false);
    	txtFieldSNSearch.setDisable(false);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(true);
    }

    @FXML
    void btnTypeHandler(ActionEvent event) {
    	btnSN.setSelected(false);
    	btnName.setSelected(false);
    	txtFieldSNSearch.setDisable(true);
    	txtFieldNameSearch.setDisable(true);
    	txtFieldTypeSearch.setDisable(false);
    }

}
