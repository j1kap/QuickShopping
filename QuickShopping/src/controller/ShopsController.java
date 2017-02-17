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
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class ShopsController implements Initializable {

	ShopService shopservice = new ShopServiceImpl();

    @FXML
    private Button editBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button addBtn;

    @FXML
    private TableView<Shop> tableShop;

    @FXML
    private TableColumn<Shop, String> shopsName;

    @FXML
    private TableColumn<Shop, String> shopAddress;

    @FXML
    void addShop(ActionEvent event) {
    	MainController.setSceneAddShop();
    }

    @FXML
    void removeShop(ActionEvent event) {

    }

    @FXML
    void editShop(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
    	initialShopList();
    	MainController.setSceneMainWindow();
    }

    @FXML
    void confitm(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initialShopList();

	}

	private void initialShopList() {
		List<Shop> list = shopservice.getShopsList();
		ObservableList<Shop> observableList = FXCollections.observableArrayList(list);
		tableShop.setItems(observableList);

		shopsName.setCellValueFactory(new PropertyValueFactory<Shop, String>("name"));
		shopAddress.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
	}

}
