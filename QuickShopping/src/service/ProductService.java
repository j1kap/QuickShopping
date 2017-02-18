package service;

import java.util.List;

import model.Product;

public interface ProductService {

	void addProduct(Product product);

	void deleteProduct(Product item);

	List<Product> getProductList();

}
