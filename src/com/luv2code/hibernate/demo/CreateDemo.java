package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor1 = new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail tempInstructorDetail1 = new InstructorDetail("http://www.youtube.com/luv2code",
					"Luv 2 Code!!!");
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);

			Instructor tempInstructor2 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

			tempInstructor2.setInstructorDetail(tempInstructorDetail2);

			session.beginTransaction();

			System.out.println("Saving instructor 1: " + tempInstructor1);
			session.save(tempInstructor1);

			System.out.println("Saving instructor 2: " + tempInstructor2);
			session.save(tempInstructor2);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
