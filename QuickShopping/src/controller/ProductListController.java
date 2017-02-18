package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class ProductListController implements Initializable {

	ShopService shopservice = new ShopServiceImpl();
	MessagePanel message = new MessagePanel();

    @FXML
    private TableView<Product> tabProduct;

    @FXML
    private TableColumn<Product, String> colProduct;

    @FXML
    private Button removeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button addBtn;

    @FXML
    void addProduct(ActionEvent event) {
    	MainController.setSceneAddProduct();
    }

    @FXML
    void removeProduct(ActionEvent event) {
    	Product item = tabProduct.getSelectionModel().getSelectedItem();
    	if(item != null){
    		shopservice.deleteProduct(item);
    		initializeProductList();
    	} else {
    		message.showErrorMessage("Nie wybrano produktu");
    	}
    }

    @FXML
    void back(ActionEvent event) {
    	MainController.setSceneMainWindow();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeProductList();

	}

	private void initializeProductList() {
		List<Product> list = shopservice.getProductList();

		ObservableList<Product> observableList = FXCollections.observableArrayList(list);
		tabProduct.setItems(observableList);

		colProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
	}

}
