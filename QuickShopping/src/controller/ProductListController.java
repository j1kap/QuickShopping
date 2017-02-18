package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Product;
import service.ProductService;
import service.ProductServiceImpl;
import service.ShopService;
import service.ShopServiceImpl;

public class ProductListController implements Initializable {

	ShopService shopservice = new ShopServiceImpl();
	MessagePanel message = new MessagePanel();
	ProductService productService = new ProductServiceImpl();

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

    private Stage window;
    private Parent parentMainWindowPane;
    private static Scene sceneMainWindow;

    private Parent parentAddProductWindow;
    private static Scene sceneAddProductWindow;

    @FXML
    void addProduct(ActionEvent event) throws IOException {

    	closeThisWindow();

    	String APP_NAME = "Shop";
    	window = new Stage();
    	parentAddProductWindow = (Parent) FXMLLoader.load(getClass().getResource("/view/addProduct.fxml"));
    	sceneAddProductWindow = new Scene(parentAddProductWindow);
    	window.setScene(sceneAddProductWindow);
    	window.setTitle(APP_NAME);
    	window.show();
    }

    @FXML
    void removeProduct(ActionEvent event) {
    	Product item = tabProduct.getSelectionModel().getSelectedItem();
    	if(item != null){
    		productService.deleteProduct(item);
    		initializeProductList();
    	} else {
    		message.showErrorMessage("Nie wybrano produktu");
    	}
    }

    void closeThisWindow(){
    	Stage stage = (Stage) addBtn.getScene().getWindow();
		stage.close();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	closeThisWindow();

    	String APP_NAME = "Shop";
    	window = new Stage();
    	parentMainWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/mainWindow.fxml"));
    	sceneMainWindow = new Scene(parentMainWindowPane);
    	window.setScene(sceneMainWindow);
    	window.setTitle(APP_NAME);
    	window.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeProductList();

	}

	private void initializeProductList() {
		List<Product> list = productService.getProductList();

		ObservableList<Product> observableList = FXCollections.observableArrayList(list);
		tabProduct.setItems(observableList);

		colProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
	}

}
