package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

	public static final String APP_NAME = "Quick Shoppingr";

	//okno aplikacji
    private static Stage window;

    //okno dla scene
    private Parent parentMainWindowPane;

    private Parent parentShopsWindowPane;
    private Parent parentCategoryPositionWindowPane;
    private Parent parentGenerateProductListWindowPane;
    private Parent parentAddShopWindow;
    private Parent parentAddProductWindow;

    //okno w ktorym znajduje sie layout
    private static Scene sceneMainWindow;

    private static Scene sceneShopsWindow;
    private static Scene sceneCategoryPositionWindow;
    private static Scene sceneGenerateProductListWindow;
    private static Scene sceneAddShopWindow;
    private static Scene sceneAddProductWindow;


	@Override
	public void start(Stage primaryStage) throws Exception {
		this.window = primaryStage;

		initializeParent();

		sceneMainWindow = new Scene(parentMainWindowPane);

		sceneShopsWindow = new Scene(parentShopsWindowPane);
		sceneCategoryPositionWindow = new Scene(parentCategoryPositionWindowPane);
		sceneGenerateProductListWindow = new Scene(parentGenerateProductListWindowPane);
		sceneAddShopWindow = new Scene(parentAddShopWindow);

		sceneAddProductWindow = new Scene(parentAddProductWindow);

		window.setScene(sceneMainWindow);
		window.setTitle(APP_NAME);
		window.show();
	}


	private void initializeParent() {

		try {
			parentMainWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/mainWindow.fxml"));

			parentShopsWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/shopsWindow.fxml"));
			parentCategoryPositionWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/categoryPositionWindow.fxml"));
			parentGenerateProductListWindowPane = (Parent) FXMLLoader.load(getClass().getResource("/view/generateProductListWindow.fxml"));
			parentAddShopWindow = (Parent) FXMLLoader.load(getClass().getResource("/view/addShopWindow.fxml"));
			parentAddProductWindow = (Parent) FXMLLoader.load(getClass().getResource("/view/addProduct.fxml"));

		} catch (IOException e) {
			System.out.println("Blad podczas wczytywania fxml");
		}

	}

	public static void setSceneMainWindow(){
		window.setScene(sceneMainWindow);
	}

	public static void setSceneShopsWindow(){
		window.setScene(sceneShopsWindow);
	}

	public static void setSceneCategoryPosition(){
		window.setScene(sceneCategoryPositionWindow);
	}

	public static void setSceneGenerateProductList(){
		window.setScene(sceneGenerateProductListWindow);
	}

	public static void setSceneAddShop(){
		window.setScene(sceneAddShopWindow);
	}

	public static void hideMainWIndow(){
        window.hide();
    }

	public static void showMainWIndow(){
        window.show();
    }

	public static void setSceneAddProduct(){
		window.setScene(sceneAddProductWindow);
	}

}
