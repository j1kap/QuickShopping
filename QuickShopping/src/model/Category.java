package model;

public class Category {

	private int id;

	private String name;
	private int idCategory;
	private int priority;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Category(int id, String name, int idCategory, int priority) {
		super();
		this.id = id;
		this.name = name;
		this.idCategory = idCategory;
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", idCategory=" + idCategory + ", priority=" + priority + "]";
	}




}
