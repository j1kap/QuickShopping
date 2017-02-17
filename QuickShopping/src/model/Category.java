package model;

public class Category {

	private int priority;
	private String name;

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
	public Category(int priority, String name) {
		this.priority = priority;
		this.name = name;
	}
}
