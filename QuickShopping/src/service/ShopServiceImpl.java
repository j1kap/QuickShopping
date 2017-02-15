package service;

import java.util.ArrayList;
import java.util.List;

import model.Shop;

public class ShopServiceImpl implements ShopService {

	@Override
	public void addShop(Shop shop) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Shop> getShopsList() {
		// Tymczasowa zaslepka, zastapic polaczeniem z DB
		List<Shop> shoList = new ArrayList<>();
		shoList.add(new Shop("Biedra", "Polna1"));
		shoList.add(new Shop("Kalflund", "Sklepowa 12"));

		return shoList;
	}

}
