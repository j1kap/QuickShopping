package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class QuickShopping implements Initializable {

    @FXML
    private Button mainShopsButton;

    @FXML
    private Button mainItemsButton;

    @FXML
    private Button mainListsButton;

    @FXML
    void goToLists(ActionEvent event) {
    	MainController.setSceneGenerateProductList();
    }

    @FXML
    void goToShops(ActionEvent event) {
    	MainController.setSceneShopsWindow();
    }

    @FXML
    void goToItems(ActionEvent event) {
    	MainController.setSceneAddProduct();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
