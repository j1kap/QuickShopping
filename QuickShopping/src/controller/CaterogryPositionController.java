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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Category;
import model.Shop;
import service.ShopService;
import service.ShopServiceImpl;

public class CaterogryPositionController implements Initializable {

	static ShopService service = new ShopServiceImpl();

    @FXML
    private Button btnBack;

    @FXML
    private TableView<Category> table;

    @FXML
    private TableColumn<Category, String> name;

    @FXML
    private TableColumn<Category, Integer> id;

    @FXML
    private TableColumn<Category, Integer> position;


    @FXML
    private Label label;



    @FXML
    private Button btnUp;

    @FXML
    private Button btnDown;

    @FXML
    void upCategory(ActionEvent event) {

    }

    @FXML
    void downCategory(ActionEvent event) {

    }

    @FXML
    void backBtn(ActionEvent event) {
    	  Stage stage = (Stage) btnBack.getScene().getWindow();
          stage.close();
          MainController.setSceneShopsWindow();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeWindow();
	}

	private void initializeWindow() {
		label.setText(service.getShop(ShopsController.idEditShop));
		//initializeTable();
	}

	private void initializeTable() {
		List<Category> list = service.getCategoryForShop(ShopsController.idEditShop);

		ObservableList<Category> observableList = FXCollections.observableArrayList(list);
		table.setItems(observableList);

		position.setCellValueFactory(new PropertyValueFactory<Category, Integer>("priority"));
		name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
	}
}
