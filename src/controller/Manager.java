package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Manager {

    @FXML
    private TextField serialNumberField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField typeField;

    @FXML
    private ListView<String> listView;

    @FXML
    private void handleSearch() {
        // search logic here

    }

    @FXML
    private void handleClear() {
        serialNumberField.clear();
        nameField.clear();
        typeField.clear();
        listView.getItems().clear();
    }

    @FXML
    private void handleBuy() {
        // buy logic here
    }
}
