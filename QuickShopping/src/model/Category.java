package model;

public class Category {

	private int id;
	private int priority;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(int id, int priority, String name) {
		this.id = id;
		this.priority = priority;
		this.name = name;
	}
}
