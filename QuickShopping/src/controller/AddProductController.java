package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Product;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class AddProductController implements Initializable {

	MessagePanel messagePanel = new MessagePanel();
	ShopService service = new ShopServiceImpl();

    @FXML
    private TextField product;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> category;

    @FXML
    private Button saveBtn;

    @FXML
    void back(ActionEvent event) {
    	MainController.setSceneMainWindow();

    }

    @FXML
    void addProducy(ActionEvent event) {
    	if (this.isNotEmptyFields()) {
    		service.addProduct(new Product(product.getText(), category.getSelectionModel().getSelectedItem()));
			messagePanel.showInformationMessage("Produkt dodany");

		} else {
			messagePanel.showErrorMessage("Nie wszystkie pola zostaly wypelnione!");
		}
    }

	private boolean isNotEmptyFields() {
		return product.getText() != null && !product.getText().isEmpty() && category.getSelectionModel().getSelectedItem() != null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeList();
	}

	private void initializeList() {
		List<String> list = service.getCategoryName();
		ObservableList<String> observableList = FXCollections.observableArrayList(list);
		category.setItems(observableList);
	}

}