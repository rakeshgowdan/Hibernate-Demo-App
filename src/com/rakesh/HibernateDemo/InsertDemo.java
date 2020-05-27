package com.rakesh.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakesh.HibernateDemo.entity.Student;

public class InsertDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		Session s=sf.getCurrentSession();
		
		try {
			s.beginTransaction();
			Student s1=new Student("raki","raki","raki@gmail.com");
			s.save(s1);
			s.getTransaction().commit();
			System.out.println("done");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		sf.close();

	}

}
