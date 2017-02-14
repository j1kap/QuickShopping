package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ShopsController implements Initializable {

    @FXML
    private Button editBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button addBtn;

    @FXML
    void addShop(ActionEvent event) {

    }

    @FXML
    void removeShop(ActionEvent event) {

    }

    @FXML
    void editShop(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
    	MainController.setSceneMainWindow();
    }

    @FXML
    void confitm(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
