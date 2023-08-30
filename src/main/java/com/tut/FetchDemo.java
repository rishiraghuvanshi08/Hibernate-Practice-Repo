package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		
		//get , load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		//load- student:103
		Student st = (Student)session.load(Student.class, 1024);
		System.out.println(st);
		
		//get- student:id=1
		Address ad = (Address)session.get(Address.class, 2);
		System.out.println(ad.getStreet() + " : " + ad.getCity());
		
		Address ad1 = (Address)session.get(Address.class, 1);
		System.out.println(ad1.getStreet() + " : " + ad1.getCity());
		
		session.close();
		factory.close();
	}
}
