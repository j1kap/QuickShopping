package service;

import java.util.ArrayList;
import java.util.List;

import controller.DatabaseServices;
import model.Category;
import model.Product;
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
		databaseServices.deleteDataFromDB("quickShopping.t_sklepy", "id_sklepu = " + selectedItem.getId().toString());
	}

	@Override
	public List<Category> getCategoryForShop(int idEditEmployee) {
		List<Category> categories = new ArrayList<>();
		categories = databaseServices.getCategoryFromDBList("t_sklepy_vs_kategorie.id_sklepu, t_kategorie.nazwa, t_sklepy_vs_kategorie.id_kategorii, t_sklepy_vs_kategorie.priorytet", "quickShopping.t_sklepy_vs_kategorie, quickShopping.t_kategorie","id_sklepu="+String.valueOf(idEditEmployee)+" and t_kategorie.id_kategorii=t_sklepy_vs_kategorie.id_kategorii order by t_sklepy_vs_kategorie.priorytet");
		return categories;
	}

	@Override
	public String getShop(int idEditEmployee) {
		return databaseServices.getStringFromDB("concat( nazwa, ' , ' , adres)", "quickShopping.t_sklepy", "id_sklepu = " + idEditEmployee);
	}

	public void moveCategory(int direction, int shopId, int categoryId)
	{

		int currentPriority = databaseServices.getIntFromDB("priorytet", "quickShopping.t_sklepy_vs_kategorie", "id_sklepu="+String.valueOf(shopId)+" and id_kategorii="+String.valueOf(categoryId));
		int newPriority = currentPriority + direction;

		int currentPriorityCategoryId = databaseServices.getIntFromDB("id_kategorii","quickShopping.t_sklepy_vs_kategorie","priorytet='"+String.valueOf(currentPriority)+"' and id_sklepu='"+String.valueOf(shopId)+"'");
		int newPriorityCategoryId = databaseServices.getIntFromDB("id_kategorii","quickShopping.t_sklepy_vs_kategorie","priorytet='"+String.valueOf(newPriority)+"' and id_sklepu='"+String.valueOf(shopId)+"'");
		databaseServices.updateDataToDB("quickShopping.t_sklepy_vs_kategorie","priorytet="+String.valueOf(newPriority), "id_sklepu='"+String.valueOf(shopId)+"' and id_kategorii='"+String.valueOf(currentPriorityCategoryId)+"'");
		databaseServices.updateDataToDB("quickShopping.t_sklepy_vs_kategorie","priorytet="+String.valueOf(currentPriority), "id_sklepu='"+String.valueOf(shopId)+"' and id_kategorii='"+String.valueOf(newPriorityCategoryId)+"'");
	}

	@Override
	public List<String> getCategoryName() {
		return databaseServices.getStringFromDBList("nazwa", "quickShopping.t_kategorie");
	}

	@Override
	public void addProduct(Product product) {
		int categoryId = databaseServices.getIntFromDB("id_kategorii","quickShopping.t_kategorie","nazwa='"+product.getCategory()+"'");
		databaseServices.insertDataToDB("quickShopping.t_produkty (nazwa, id_kategorii) ","'"+product.getName()+"',"+String.valueOf(categoryId));
	}

	@Override
	public List<String> getShopsName() {
		return databaseServices.getStringFromDBList("concat( nazwa, ' , ' , adres)", "quickShopping.t_sklepy");
	}

	@Override
	public List<Product> getProductList() {
		return databaseServices.getAllProducts();
	}

}
