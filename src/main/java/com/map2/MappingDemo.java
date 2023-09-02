package com.map2;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Creating employee
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setId(1);
		e1.setName("Ram");
		
		e2.setId(2);
		e2.setName("Shyam");
		
		// Creating projects
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(101);
		p1.setProjectName("Online Library");
		
		p2.setPid(103);
		p2.setProjectName("ChatBot");
		
		List<Employee> l1 = new ArrayList<>();
		l1.add(e1);
		l1.add(e2);
		
		List<Project> pl2 = new ArrayList<>();
		pl2.add(p1);
		pl2.add(p2);
		
		List<Project> pl1 = new ArrayList<>();
		pl1.add(p2);
		
		// e1 and e2
		e1.setProjects(pl2);
		e2.setProjects(pl1);
		
		// p1
		p1.setEmps(l1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
