package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int theId = 1;

			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, theId);

			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");

			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			session.save(tempCourse1);
			session.save(tempCourse2);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
