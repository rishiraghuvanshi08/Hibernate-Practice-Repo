package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws HibernateException, IOException{
		System.out.println("Project Started..");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Student
		Student st = new Student();
		st.setId(105);
		st.setName("Ayush");
		st.setCity("Banglore");
		System.out.println(st);
		
		// Creating object of address class
		Address add = new Address();
		add.setStreet("Street 2");
		add.setCity("Hydrabad");
		add.setOpen(false);
		add.setAddedDate(new Date());
		add.setX(54687.254);
		
		// Reading Image
		FileInputStream fis = new FileInputStream("src/main/java/55757.JPG");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		add.setImage(data);
		fis.close();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(add);
		tx.commit();
		
		session.close();
		System.out.println("Done..");
	}
}