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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.ShopService;
import service.ShopServiceImpl;

public class AddProductController implements Initializable {

	MessagePanel messagePanel = new MessagePanel();
	ShopService shopService = new ShopServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();

    @FXML
    private TextField product;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> category;

    @FXML
    private Button saveBtn;

    private Stage window;
	private static Scene sceneListProductWindow;
	private Parent parenListProductWindow;

    @FXML
    void back(ActionEvent event) throws IOException {
    	backToWindow();

    }

    void backToWindow() throws IOException{
    	closeWindow();

    	String APP_NAME = "Shop";
        window = new Stage();
        parenListProductWindow = (Parent) FXMLLoader.load(getClass().getResource("/view/productListWindow.fxml"));
    	sceneListProductWindow = new Scene(parenListProductWindow);
		window.setScene(sceneListProductWindow);
        window.setTitle(APP_NAME);
        window.show();
    }

    void closeWindow(){
    	Stage stage = (Stage) saveBtn.getScene().getWindow();
		stage.close();
    }

    @FXML
    void addProducy(ActionEvent event) throws IOException {
    	if (this.isNotEmptyFields()) {
    		productService.addProduct(new Product(product.getText(), category.getSelectionModel().getSelectedItem()));
			messagePanel.showInformationMessage("Produkt dodany");
			backToWindow();
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
		List<String> list = categoryService.getCategoryName();
		ObservableList<String> observableList = FXCollections.observableArrayList(list);
		category.setItems(observableList);
	}

}