package service;

import java.util.List;

import controller.DatabaseServices;
import model.Product;

public class ProductServiceImpl implements ProductService {


	DatabaseServices databaseServices;

	public ProductServiceImpl() {
		databaseServices = new DatabaseServices();
	}

	@Override
	public void addProduct(Product product) {
		int categoryId = databaseServices.getIntFromDB("id_kategorii","quickShopping.t_kategorie","nazwa='"+product.getCategory()+"'");
		databaseServices.insertDataToDB("quickShopping.t_produkty (nazwa, id_kategorii) ","'"+product.getName()+"',"+String.valueOf(categoryId));
	}

	@Override
	public void deleteProduct(Product item) {
		databaseServices.deleteDataFromDB("quickShopping.t_produkty", "id_produktu="+item.getId());

	}

	@Override
	public List<Product> getProductList() {
		return databaseServices.getAllProducts();
	}

}
