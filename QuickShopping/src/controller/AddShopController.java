package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class AddShopController implements Initializable {

	MessagePanel messagePanel;
	ShopService shopservice;

	@FXML
	private Button save;

	@FXML
	private TextField shopName;

	@FXML
	private Button back;

	@FXML
	private TextField shopAddress;

	private Stage window;
	private static Scene sceneShopsWindow;
	private Parent parentShopsWindowPane;

	@FXML
	void add(ActionEvent event) throws IOException {

		if (this.isNotEmptyFields()) {
			shopservice.addShop(new Shop(getShopName(), getShopAddress()));
			messagePanel.showInformationMessage("Sklep dodany");
			initializeShopsWindow();
		} else {
			messagePanel.showErrorMessage("Nie wszystkie pola zostaly wypelnione!");
		}

	}

	public String getShopName() {
		return shopName.getText();
	}


	public String getShopAddress() {
		return shopAddress.getText();
	}

	private boolean isNotEmptyFields() {
		return getShopName() != null && getShopAddress() != null;
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		initializeShopsWindow();

		//MainController.setSceneShopsWindow();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messagePanel = new MessagePanel();
		shopservice = new ShopServiceImpl();
	}

	void initializeShopsWindow() throws IOException{
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();

	

		String APP_NAME = "Shop";
        window = new Stage();
    	parentShopsWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/shopsWindow.fxml"));
		sceneShopsWindow = new Scene(parentShopsWindowPane);
		window.setScene(sceneShopsWindow);
        window.setTitle(APP_NAME);
        window.show();
	}

}
