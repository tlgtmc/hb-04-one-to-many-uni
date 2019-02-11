package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Instructor;
import com.tlgtmc.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// this will also save the detail object since we set CascadeType.ALL
			int theId = 20;

			InstructorDetail tempInstructor = session.get(InstructorDetail.class, theId);

			if (tempInstructor != null) {
				// This will also delete detail since it's connected with CascadeType.ALL
				System.out.println(tempInstructor);
				System.out.println(tempInstructor.getInstructor());
			}

			session.getTransaction().commit();

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
