package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Instructor;
import com.tlgtmc.hibernate.demo.entity.InstructorDetail;
import com.tlgtmc.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

//			Instructor tmpInstructor = new Instructor("Tolga", "Atmaca", "tttt@gmail.com");
//
//			InstructorDetail tmpInstructorDetail = new InstructorDetail("tlgtmc", "Making Military Models");
			

			Instructor tmpInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

			InstructorDetail tmpInstructorDetail = new InstructorDetail("youtube", "Guitar");

			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			session.beginTransaction();

			// this will also save the detail object since we set CascadeType.ALL
			session.save(tmpInstructor);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
