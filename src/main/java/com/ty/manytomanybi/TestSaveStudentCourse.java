package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = new Student();
		student.setName("karthik");
		student.setAge(21);

		Student student1 = new Student();
		student1.setName("prasad");
		student1.setAge(22);
		
		Student student2 = new Student();
		student2.setName("pooja");
		student2.setAge(23);
		
		Course course1 = new Course();
		course1.setName("HTML");
		course1.setDuration("5");

		Course course2 = new Course();
		course2.setName("CSS");
		course2.setDuration("10");

		Course course3 = new Course();
		course3.setName("Java");
		course3.setDuration("20");

		List<Course> courses = new ArrayList<Course>();

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(course1);
		courses1.add(course2);
		
		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(course1);
		courses2.add(course3);
		
		
		student.setCourses(courses);
		student1.setCourses(courses1);
		student2.setCourses(courses2);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student2);
		
		
		course1.setStudent(students);
		course2.setStudent(students);
		course3.setStudent(students);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
	}

}
