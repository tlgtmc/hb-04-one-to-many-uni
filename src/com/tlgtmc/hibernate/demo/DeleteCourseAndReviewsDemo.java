package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Course;
import com.tlgtmc.hibernate.demo.entity.Instructor;
import com.tlgtmc.hibernate.demo.entity.InstructorDetail;
import com.tlgtmc.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {


			session.beginTransaction();
			int theId = 10;
			
			Course course = session.get(Course.class, theId);
			
			System.out.println(course);
			
			System.out.println(course.getReviewList());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			
			session.close();
			factory.close();
		}

	}

}
