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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CustomProduct;
import service.ShopService;
import service.ShopServiceImpl;

public class CustomProductListController implements Initializable {

	FileServices fileServices = new FileServices();
	ShopService service = new ShopServiceImpl();
	MessagePanel message = new MessagePanel();

	List<CustomProduct> list;


    @FXML
    private TableView<CustomProduct> tabProduct;

    @FXML
    private TableColumn<CustomProduct, String> nameCol;

    @FXML
    private Label shop;

    @FXML
    private Button save;

    @FXML
    private Button back;

    private Stage window;
    private Parent parentGenerateProductListWindowPane;
    private static Scene sceneGenerateProductListWindow;

    @FXML
    void save(ActionEvent event) throws IOException {
    	fileServices.saveToTXT(GenerateProductListController.generetedList);
    	message.showInformationMessage("Lista zostala wygenerowana");
    	backToWindow();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	backToWindow();
    }

    void closeWindow(){
    	Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
    }

    void backToWindow() throws IOException{
    	closeWindow();

    	String APP_NAME = "Shop";
        window = new Stage();
    	parentGenerateProductListWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/generateProductListWindow.fxml"));
        sceneGenerateProductListWindow = new Scene(parentGenerateProductListWindowPane);
		window.setScene(sceneGenerateProductListWindow);
        window.setTitle(APP_NAME);
        window.show();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		list = new ArrayList<>();

		for(String product : GenerateProductListController.generetedList){
			list.add(new CustomProduct(product));
		}

		ObservableList<CustomProduct> observableList = FXCollections.observableArrayList(list);
		tabProduct.setItems(observableList);

		nameCol.setCellValueFactory(new PropertyValueFactory<CustomProduct, String>("name"));

		shop.setText(GenerateProductListController.shopName);

	}

}