package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Course;
import com.tlgtmc.hibernate.demo.entity.Instructor;
import com.tlgtmc.hibernate.demo.entity.InstructorDetail;

public class CreateInstuctorDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			Instructor tmpInstructor = new Instructor("Susan", "Public", "sp@gmail.com");

			InstructorDetail tmpInstructorDetail = new InstructorDetail("youtube", "Video Games");

			tmpInstructor.setInstructorDetail(tmpInstructorDetail);

			session.beginTransaction();

			// this will also save the detail object since we set CascadeType.ALL
			session.save(tmpInstructor);

			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			
			session.close();
			factory.close();
		}

	}

}
