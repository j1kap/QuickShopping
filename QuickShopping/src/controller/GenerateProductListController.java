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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class GenerateProductListController implements Initializable {

	MessagePanel message = new MessagePanel();
	ShopService service = new ShopServiceImpl();

	List<Product> myProductList = new ArrayList<>();
	List<Product> allProductList;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Button deleteItem;

    @FXML
    private Button addToMainList;

    @FXML
    private Button generateList;

    @FXML
    private Button back;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> allProduct;

    @FXML
    private TableView<Product> myProductTable;

    @FXML
    private TableColumn<Product, String> myProduct;


	@FXML
    void deleteItem(ActionEvent event) {
		Product item = myProductTable.getSelectionModel().getSelectedItem();
    	if( item != null){
    		myProductList.remove(item);
    		allProductList.add(item);
    		setProductTables(allProductList, myProductList);
    	} else {
    		message.showErrorMessage("Nie wybrano poprawnie produktu");
    	}
    }

    @FXML
    void generateProductsList(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
    	myProductList.clear();
    	setProductIntable(myProductList, myProductTable,myProduct);

    	allProductList.clear();
    	initializeProductList();
    	MainController.setSceneMainWindow();
    }

    @FXML
    void addToList(ActionEvent event) {
    	Product item = productTable.getSelectionModel().getSelectedItem();
    	if( item != null){
    		allProductList.remove(item);
    		myProductList.add(item);
    		setProductTables(allProductList, myProductList);
    	} else {
    		message.showErrorMessage("Nie wybrano poprawnie produktu");
    	}
    }


	private void setProductTables(List<Product> allProductList, List<Product> myProductList) {
		setProductIntable(allProductList,productTable,allProduct);
		setProductIntable(myProductList,myProductTable,myProduct);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initialiceShopList();
		initializeProductList();

	}

	private void initializeProductList() {
		allProductList = service.getProductList();
		setProductIntable(allProductList,productTable, allProduct);
	}

	private void setProductIntable(List<Product> productList, TableView<Product> productTable, TableColumn<Product, String> allProduct) {
		ObservableList<Product> observableList = FXCollections.observableArrayList(productList);
		productTable.setItems(observableList);

		allProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

	}

	void initialiceShopList(){
		List<String> list = service.getShopsName();
		ObservableList<String> observableList = FXCollections.observableArrayList(list);
		combo.setItems(observableList);
	}

}
