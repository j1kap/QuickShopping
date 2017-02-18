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

	List<Category> getCategoryForShop(int idEditEmployee);

	String getShop(int idEditEmployee);

	public void moveCategory(int direction, int shopId, int categoryId);

	List<String> getCategoryName();

	void addProduct(Product product);

	List<String> getShopsName();

	List<Product> getProductList();

	void generateList(Shop string, List<Product> myProductList);

	void deleteProduct(Product item);

}
