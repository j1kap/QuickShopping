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
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class ShopsController implements Initializable {

	ShopService shopservice = new ShopServiceImpl();
	MessagePanel message = new MessagePanel();

	public static int idEditShop;

    @FXML
    private Button removeBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button addBtn;

    @FXML
    private TableView<Shop> tableShop;

    @FXML
    private TableColumn<Shop, String> shopsName;

    @FXML
    private TableColumn<Shop, String> shopAddress;


	private Stage window;
	Parent parentEditEmployeeWindowPane;
	Scene sceneEditEmployeeWindow;

    private static Scene sceneAddShopsWindow;
    private Parent parentAddShopsWindowPane;

    private Parent parentMainWindowPane;
    private static Scene sceneMainWindow;

    @FXML
    void addShop(ActionEvent event) throws IOException {
    	closeThisWindow();

    	String APP_NAME = "Shop";
    	window = new Stage();
    	parentAddShopsWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/addShopWindow.fxml"));
    	sceneAddShopsWindow = new Scene(parentAddShopsWindowPane);
    	window.setScene(sceneAddShopsWindow);
    	window.setTitle(APP_NAME);
    	window.show();
    }

    void closeThisWindow(){
    	Stage stage = (Stage) addBtn.getScene().getWindow();
		stage.close();
    }

    @FXML
    void removeShop(ActionEvent event) {

    	if(tableShop.getSelectionModel().getSelectedItem() != null){
    		shopservice.remove(tableShop.getSelectionModel().getSelectedItem());
    		initialShopList();
    	} else {
    		message.showErrorMessage("Nie wybrano obiektu");
    	}

    }

    @FXML
    void editCategory(ActionEvent event) {
    	try {
			initliazeNewWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initliazeNewWindow() throws IOException {
		idEditShop = getEditIdShop();

		if(idEditShop != 0 ){

			closeThisWindow();

			String APP_NAME = "Shop";
	        window = new Stage();
	        parentEditEmployeeWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/categoryPositionWindow.fxml"));
	        sceneEditEmployeeWindow = new Scene(parentEditEmployeeWindowPane);
	        window.setScene(sceneEditEmployeeWindow);
	        window.setTitle(APP_NAME);
	        window.show();
		}
	}

	private int getEditIdShop() {
		int id = 0;

		if(tableShop.getSelectionModel().getSelectedItem() != null){
			id = tableShop.getSelectionModel().getSelectedItem().getId();
    	} else {
    		message.showErrorMessage("Nie wybrano obiektu");
    	}

		return id;
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

		initialShopList();

	}

	public void initialShopList() {
		List<Shop> list = shopservice.getShopsList();
		ObservableList<Shop> observableList = FXCollections.observableArrayList(list);
		tableShop.setItems(observableList);

		shopsName.setCellValueFactory(new PropertyValueFactory<Shop, String>("name"));
		shopAddress.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
	}

}
