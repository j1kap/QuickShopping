package service;

import java.util.ArrayList;
import java.util.List;

import controller.DatabaseServices;
import model.Product;
import model.Shop;

public class GeneratorServiceImpl implements GeneratorService {

	DatabaseServices databaseServices;

	public GeneratorServiceImpl() {
		databaseServices = new DatabaseServices();
	}

	@Override
	public List<String> generateList(Shop shop, List<Product> myProductList) {

		List<Integer> productsId = new ArrayList<>();

		for(Product prod : myProductList){
			productsId.add(prod.getId());
		}

		return databaseServices.sortProductByShopPriority(shop, productsId);
	}

}
