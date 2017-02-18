package service;

import java.util.List;

import model.Category;

public interface CategoryService {

	List<Category> getCategoryForShop(int idEditEmployee);

	public void moveCategory(int direction, int shopId, int categoryId);

	List<String> getCategoryName();

}
