package com.luv2.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2.code.hibernate.demo.entity.Course;
import com.luv2.code.hibernate.demo.entity.Instructor;
import com.luv2.code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
				
		try {
			
			session.beginTransaction();
			
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: "+tempInstructor);
			
			//Retrieve the courses
			System.out.println("Courses: "+tempInstructor.getCourses());
			
			session.getTransaction().commit();
			System.out.println("Done!");
						
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
