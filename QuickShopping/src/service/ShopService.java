package service;

import java.util.List;

import model.Category;
import model.Shop;

public interface ShopService {

	void addShop(Shop shop);

	List<Shop> getShopsList();

	void remove(Shop selectedItem);

	List<Category> getCategoryForShop(int idEditEmployee);

	String getShop(int idEditEmployee);

	public void moveCategory(int direction, int shopId, int categoryId);

}
