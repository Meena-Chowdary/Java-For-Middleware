package com.w.training.beans;

public class BookCatalogItem {

	String name, description;
	int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public BookCatalogItem(String name, String description, int rating) {
		this.name = name;
		this.description = description;
		this.rating = rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
