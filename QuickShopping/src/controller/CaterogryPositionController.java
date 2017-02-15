package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CaterogryPositionController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TextField shopData;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> position;

    @FXML
    private Button btnUp;

    @FXML
    private Button btnDown;

    @FXML
    void upCategory(ActionEvent event) {

    }

    @FXML
    void downCategory(ActionEvent event) {

    }

    @FXML
    void backBtn(ActionEvent event) {
    	MainController.setSceneMainWindow();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
