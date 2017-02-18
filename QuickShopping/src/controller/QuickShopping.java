package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class QuickShopping implements Initializable {

    @FXML
    private Button mainShopsButton;

    @FXML
    private Button mainItemsButton;

    @FXML
    private Button mainListsButton;

    private Stage window;
    private static Scene sceneGenerateProductListWindow;
    private Parent parentGenerateProductListWindowPane;

    @FXML
    void goToLists(ActionEvent event) throws IOException {
    	String APP_NAME = "Shop";
        window = new Stage();
        parentGenerateProductListWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/generateProductListWindow.fxml"));
    	sceneGenerateProductListWindow = new Scene(parentGenerateProductListWindowPane);
    	 window.setScene(sceneGenerateProductListWindow);
         window.setTitle(APP_NAME);
         window.show();
		MainController.hideMainWIndow();
    }

    @FXML
    void goToShops(ActionEvent event) {
    	MainController.setSceneShopsWindow();
    }

    @FXML
    void goToItems(ActionEvent event) {
    	MainController.setSceneProductListWindow();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
