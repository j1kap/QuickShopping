package model;

public class Product {

	private String name;
	private String category;
	private int categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Product(String name, int categoryId) {
		this.name = name;
		this.categoryId = categoryId;
	}

	public Product(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}

}
