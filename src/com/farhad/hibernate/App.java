package com.farhad.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.farhad.hibernate.entity.Users;

import javassist.bytecode.Descriptor.Iterator;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			// List of all users
			session.beginTransaction();
			
			List<Users> users = session.createQuery("from users").getResultList();
			
			for(Users user : users) {
				System.out.println(user);
			}
			
			session.getTransaction().commit();
			
			
			/****** Delete Operation
			// Create object of entity class type
			Users user = new Users();
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			user = session.get(Users.class, 2);
			
			// Deleting a record with user id 2
			session.delete(user);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println(user);
			*/
			
			/******* Update Operation
			// Create object of entity class type
			Users user = new Users();
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			user = session.get(Users.class, 2);
			user.setUsername("samiur");
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println(user);
			*/
			
			
			/******** Read Operation
			// Create object of entity class type
			Users user = new Users();
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			user = session.get(Users.class, 2);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println(user);
			*/
			
			
			/******* Insert Operation 
			// Create object of entity class type
			Users user = new Users("Masud", "12345", "Masud", "Mia");
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			session.save(user);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Row added!");
		*/
			
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
