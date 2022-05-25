package com.ty.manytomanybi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetStudentCoarse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Student student = entityManager.find(Student.class,1);
		
		List<Course> courses = student.getCourses();
		for (Course course : courses) {
			System.out.println(course.getName());
			System.out.println(course.getDuration());
		}
		System.out.println(student.getName());
		System.out.println(student.getAge());
		
		
	}

}
