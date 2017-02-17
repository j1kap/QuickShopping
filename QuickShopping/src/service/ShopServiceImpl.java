package service;

import java.util.List;

import controller.DatabaseServices;
import model.Category;
import model.Shop;

public class ShopServiceImpl implements ShopService {

	DatabaseServices databaseServices;

	public ShopServiceImpl() {
		databaseServices = new DatabaseServices();
	}

	@Override
	public void addShop(Shop shop) {
		databaseServices.insertDataToDB("quickShopping.t_sklepy (nazwa,adres )", shop.getName(), shop.getAddress());
	}

	@Override
	public List<Shop> getShopsList() {
		return databaseServices.getAllShop();
	}

	@Override
	public void remove(Shop selectedItem) {
		databaseServices.deleteDataFromDB("quickShopping.t_sklepy", "id_sklepu = " + selectedItem.getId().toString());
	}

	@Override
	public List<Category> getCategoryForShop(int idEditEmployee) {
		return null;
	}

	@Override
	public String getShop(int idEditEmployee) {
		return databaseServices.getStringFromDB("nazwa, adres", "quickShopping.t_sklepy", "id_sklepu = " + idEditEmployee);
	}

}
