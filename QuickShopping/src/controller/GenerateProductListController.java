package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class GenerateProductListController implements Initializable {

    @FXML
    private TableColumn<?, ?> allProduct;

    @FXML
    private Button deleteItem;

    @FXML
    private Button addToMainList;

    @FXML
    private Button generateList;

    @FXML
    private Button back;

    @FXML
    private TableColumn<?, ?> mainProduct;

    @FXML
    void deleteItem(ActionEvent event) {

    }

    @FXML
    void generateProductsList(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
    	MainController.setSceneMainWindow();
    }

    @FXML
    void addToList(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
