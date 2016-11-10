package com.hibernate.example.manytomany.spring_hibernate_example;

import java.util.HashSet;
import java.util.Set;

import com.hibernate.example.manytomany.dao.ManyToManyDAO;
import com.hibernate.example.manytomany.entity.Category;
import com.hibernate.example.manytomany.entity.Stock;

/**
 * Many to many Hibernate configuration.
 *
 */
public class App {

	static ManyToManyDAO manyToManyDAO;
	static int counter = 1;

	public static void main(String[] args) {
		System.out.println("Many to many Hibernate configuration..");
		addStocks();
	}

	/**
	 * Adds stocks and categories
	 */
	private static void addStocks() {

		manyToManyDAO = new ManyToManyDAO();

		Stock newStock = new Stock();
		Set<Category> categories = new HashSet<Category>();

		for(counter=1;counter<5;counter++) {
		newStock.setStockCode("Stock Code " + counter);
		newStock.setStockName("Stock Name" + counter);

		Category firstCategory = new Category();
		firstCategory.setName("Category A" + counter);
		firstCategory.setDescription("Category A" + counter + " for Stock");
		Category secondCategory = new Category();
		secondCategory.setName("Category B" + counter);
		secondCategory.setDescription("Category B" + counter + " for Stock");
		categories.add(firstCategory);
		categories.add(secondCategory);

		newStock.setCategories(categories);

		manyToManyDAO.addStock(newStock);

		System.out.println("Stock "+counter+" Saved !");
		}
	}
}
