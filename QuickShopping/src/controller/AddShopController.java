package controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

	@FXML
	void add(ActionEvent event) {

		if (this.isNotEmptyFields()) {
			shopservice.addShop(new Shop(getShopName(), getShopAddress()));
			messagePanel.showInformationMessage("Sklep dodany");

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
	void back(ActionEvent event) {
		MainController.setSceneShopsWindow();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messagePanel = new MessagePanel();
		shopservice = new ShopServiceImpl();
	}

}
