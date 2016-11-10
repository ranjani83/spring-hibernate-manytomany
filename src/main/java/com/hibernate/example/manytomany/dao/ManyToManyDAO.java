package com.hibernate.example.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.example.manytomany.entity.Stock;

public class ManyToManyDAO {
	private static final SessionFactory sessionF = new Configuration().configure().buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionF;
	}

	/**
	 * saves stock to DB, which saves the associated category and stock_category
	 * mapping.
	 * 
	 * @param stock
	 */
	public void addStock(Stock stock) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();

		session.save(stock);
		session.getTransaction().commit();

		session.close();

		System.out.println("Stock Saved !");
	}

}
