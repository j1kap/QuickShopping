package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Product;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class GenerateProductListController implements Initializable {

	MessagePanel message = new MessagePanel();
	ShopService service = new ShopServiceImpl();

	private Stage window;
	Parent parenCustomListProductWindow;
	Scene sceneCustomListProductWindow;

	public static List<String> generetedList = new ArrayList<>();
	public static String shopName;

	List<Product> myProductList = new ArrayList<>();
	List<Product> allProductList;

    @FXML
    private ComboBox<Shop> combo;

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
    	if(myProductList.size() == 0 || combo.getSelectionModel().getSelectedItem() == null) {
    		message.showErrorMessage("Nie wybrano poprawnie produktu lub sklepu");
    	} else {
    		generetedList = service.generateList(combo.getSelectionModel().getSelectedItem(),myProductList );
    		shopName = combo.getSelectionModel().getSelectedItem().getName() + " , Adres: " + combo.getSelectionModel().getSelectedItem().getAddress() ;

    		try {
				initializeWindow();
			} catch (IOException e) {
				e.printStackTrace();
			}

    	}
    }

    private void initializeWindow() throws IOException {
    	String APP_NAME = "Shop";
        window = new Stage();
        parenCustomListProductWindow = (Parent) FXMLLoader.load(getClass().getResource("/view/customProductListWindow.fxml"));
        sceneCustomListProductWindow = new Scene(parenCustomListProductWindow);
        window.setScene(sceneCustomListProductWindow);
        window.setTitle(APP_NAME);
        window.show();
        closeWindow();

	}

	@FXML
    void back(ActionEvent event) {
    	myProductList.clear();
    	//setProductIntable(myProductList, myProductTable,myProduct);

    	allProductList.clear();
    	//initializeProductList();
    	closeWindow();
    	
		MainController.showMainWindow();
    }
	
	void closeWindow(){
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
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
		List<Shop> list = service.getShopsList();
		ObservableList<Shop> observableList = FXCollections.observableArrayList(list);
		combo.setItems(observableList);
	}

}
