package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Creating question 1
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
		
		// Creating answer 1
		Answer answer = new Answer();
		answer.setAnswerID(343);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);
		
		q1.setAnswer(answer);
		
		// Creating question 2
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection Framework?");
				
		// Creating answer 2
		Answer answer2 = new Answer();
		answer2.setAnswerID(344);
		answer2.setAnswer("API to work with objects in java");
		answer2.setQuestion(q2);
		
		q2.setAnswer(answer2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//save
		s.save(q1);
		s.save(q2);
		s.save(answer);
		s.save(answer2);
		
		tx.commit();
		
		Question ques = (Question)s.get(Question.class, 242);
		System.out.println(ques.getQuestion());
		System.out.println(ques.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}
}
