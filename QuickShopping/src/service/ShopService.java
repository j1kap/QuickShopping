package service;

import java.util.List;

import model.Shop;

public interface ShopService {

	void addShop(Shop shop);

	List<Shop> getShopsList();

}
