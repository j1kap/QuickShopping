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
    private Label label;

    @FXML
    private TableColumn<Category, Integer> position;

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
    	MainController.setSceneMainWindow();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//label.setText(service.getShop(6));
	}

	private void initializeTable() {
		List<Category> list = service.getCategoryForShop(ShopsController.idEditEmployee);

		ObservableList<Category> observableList = FXCollections.observableArrayList(list);
		table.setItems(observableList);

		position.setCellValueFactory(new PropertyValueFactory<Category, Integer>("priority"));
		name.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
	}
}
