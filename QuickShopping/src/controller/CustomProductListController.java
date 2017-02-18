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

    @FXML
    void save(ActionEvent event) {
    	fileServices.saveToTXT(GenerateProductListController.generetedList);
    }

    @FXML
    void back(ActionEvent event) {
    	Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    	MainController.showMainWindow();
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