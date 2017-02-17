package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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


	}

	@Override
	public List<Shop> getShopsList() {
		List<Shop> list = new ArrayList<>();

		System.out.println(databaseServices.getRecordQuantityFromDB("quickShopping.t_sklepy"));


		return list;
	}

}
