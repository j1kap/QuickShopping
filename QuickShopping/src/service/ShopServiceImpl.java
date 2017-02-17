package service;

import java.util.List;

import controller.DatabaseServices;
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

}
