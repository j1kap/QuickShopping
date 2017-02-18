package service;

import java.util.ArrayList;
import java.util.List;

import controller.DatabaseServices;
import model.Category;

public class CategoryServiceImpl implements CategoryService {

	DatabaseServices databaseServices;

	public CategoryServiceImpl() {
		databaseServices = new DatabaseServices();
	}

	@Override
	public List<Category> getCategoryForShop(int idEditEmployee) {
		List<Category> categories = new ArrayList<>();
		categories = databaseServices.getCategoryFromDBList("t_sklepy_vs_kategorie.id_sklepu, t_kategorie.nazwa, t_sklepy_vs_kategorie.id_kategorii, t_sklepy_vs_kategorie.priorytet", "quickShopping.t_sklepy_vs_kategorie, quickShopping.t_kategorie","id_sklepu="+String.valueOf(idEditEmployee)+" and t_kategorie.id_kategorii=t_sklepy_vs_kategorie.id_kategorii order by t_sklepy_vs_kategorie.priorytet");
		return categories;
	}

	@Override
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
}
