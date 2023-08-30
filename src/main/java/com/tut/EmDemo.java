package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		
		// Student 1
		Student s1 = new Student();
		s1.setId(1234);
		s1.setName("Rishi");
		s1.setCity("Indore");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Python");
		certificate.setDuration("1 month");
		
		s1.setCerti(certificate);
		
		// Student 2
		Student s2 = new Student();
		s2.setId(1235);
		s2.setName("Ram");
		s2.setCity("IIST");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("ED");
		certificate1.setDuration("4 months");
		
		s2.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//object save
		s.save(s1);
		s.save(s2);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
