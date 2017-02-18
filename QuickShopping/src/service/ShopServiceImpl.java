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
		databaseServices.insertDataToDB("quickShopping.t_sklepy (nazwa,adres)", shop.getName(),shop.getAddress());
		int shopId = databaseServices.getIntFromDB("id_sklepu","quickShopping.t_sklepy","nazwa='"+shop.getName()+"' and adres='"+shop.getAddress()+"'");
		int categoryCounter = databaseServices.getRecordQuantityFromDB("quickShopping.t_kategorie");
		for (int i = 1; i <= categoryCounter; i++)
		{
			databaseServices.insertDataToDB("quickShopping.t_sklepy_vs_kategorie (id_sklepu,id_kategorii,priorytet)","'"+shopId+"','"+String.valueOf(i)+"','"+String.valueOf(i)+"'");
		}
	}

	@Override
	public List<Shop> getShopsList() {
		return databaseServices.getAllShop();
	}

	@Override
	public void remove(Shop selectedItem) {
		String shopId = selectedItem.getId().toString();
		databaseServices.deleteDataFromDB("quickShopping.t_sklepy", "id_sklepu = " + shopId);
		databaseServices.deleteDataFromDB("quickShopping.t_sklepy_vs_kategorie", "id_sklepu = "+shopId);
	}

	@Override
	public String getShop(int idEditEmployee) {
		return databaseServices.getStringFromDB("concat( nazwa, ' , ' , adres)", "quickShopping.t_sklepy", "id_sklepu = " + idEditEmployee);
	}

	@Override
	public List<String> getShopsName() {
		return databaseServices.getStringFromDBList("concat( nazwa, ' , ' , adres)", "quickShopping.t_sklepy");
	}



}
