package service;

import java.util.List;

import javafx.collections.ObservableList;
import model.Category;
import model.Product;
import model.Shop;

public interface ShopService {

	void addShop(Shop shop);

	List<Shop> getShopsList();

	void remove(Shop selectedItem);

	String getShop(int idEditEmployee);

	List<String> getShopsName();
}
