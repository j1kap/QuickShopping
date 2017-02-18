package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import service.ShopService;
import service.ShopServiceImpl;

public class GenerateProductListController implements Initializable {

	MessagePanel message = new MessagePanel();
	ShopService service = new ShopServiceImpl();

    @FXML
    private ComboBox<String> combo;

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
    void isSelected(ActionEvent event) {
    	System.out.println("dotknol mnie!");
    }


    @FXML
    void deleteItem(ActionEvent event) {

    }

    @FXML
    void generateProductsList(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void addToList(ActionEvent event) {

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		List<String> list = service.getShopsName();
		ObservableList<String> observableList = FXCollections.observableArrayList(list);
		combo.setItems(observableList);
	}

}
