package com.map;

import java.util.ArrayList;
import java.util.List;

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
		
		Answer answer2 = new Answer();
		answer2.setAnswerID(344);
		answer2.setAnswer("Java is Object Oriented Programming");
		answer2.setQuestion(q1);
		
		Answer answer3 = new Answer();
		answer3.setAnswerID(345);
		answer3.setAnswer("Java is used for software creation");
		answer3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<>();
		list.add(answer);
		list.add(answer2);
		list.add(answer3);
		
		q1.setAnswer(list);
		
		// For OneToOne Mapping Practice
//		q1.setAnswer(answer);
//		
//		// Creating question 2
//		Question q2 = new Question();
//		q2.setQuestionId(242);
//		q2.setQuestion("What is Collection Framework?");
//				
//		// Creating answer 2
//		Answer answer2 = new Answer();
//		answer2.setAnswerID(344);
//		answer2.setAnswer("API to work with objects in java");
//		answer2.setQuestion(q2);
//		
//		q2.setAnswer(answer2);
//		
//		// Creating question 3
//		Question q3 = new Question();
//		q3.setQuestionId(242);
//		q3.setQuestion("What is Eclipse");
//				
//		// Creating answer 3
//		Answer answer3 = new Answer();
//		answer3.setAnswerID(344);
//		answer3.setAnswer("IDE for writing codes");
//		answer3.setQuestion(q3);
//		
//		q3.setAnswer(answer3);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//save
//		s.save(q1);
//		s.save(q2);
//		s.save(q3);
//		s.save(answer);
//		s.save(answer2);
//		s.save(answer3);
		
		s.save(q1);
		s.save(answer);
		s.save(answer2);
		s.save(answer3);
		
		tx.commit();
		
		// Fetching
//		Question ques = (Question)s.get(Question.class, 242);
//		System.out.println(ques.getQuestion());
//		System.out.println(ques.getAnswer().getAnswer());
		
		
		// Fetching
		Question ques = (Question)s.get(Question.class, 1212);
		System.out.println(ques.getQuestion());
		
		for(Answer e: q1.getAnswer())
			System.out.println(e.getAnswer());
		
		s.close();
		factory.close();
	}
}
