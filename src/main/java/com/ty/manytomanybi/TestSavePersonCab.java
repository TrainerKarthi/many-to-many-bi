package com.ty.manytomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestSavePersonCab {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karthik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		//person1
		Person person = new Person();
		person.setName("karthik");
		person.setAge(21);
		person.setEmail("karthik@gmail.com");
		
		//person2
		Person person1 = new Person();
		person1.setName("chawan");
		person1.setAge(21);
		person1.setEmail("chawan@gmail.com");

		//person3
		Person person2 = new Person();
		person2.setName("prasad");
		person2.setAge(21);
		person2.setEmail("prasad@gmail.com");
		
		
		//cab1
		Cab cab1 = new Cab();
		cab1.setDriverName("inky");
		cab1.setCost(500);

		//cab2
		Cab cab2 = new Cab();
		cab2.setDriverName("pinky");
		cab2.setCost(499);

		//if we want to book one cab for two persons
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person1);
		
		//if we want to book one cab for three persons
		List<Person> persons1 = new ArrayList<Person>();
		persons1.add(person);
		persons1.add(person1);
		persons1.add(person2);
		
		
		//for cab1 contains two persons
		cab1.setPerson(persons);
		
		//for cab2 contains three person
		cab2.setPerson(persons1);
		
		List<Cab> cabs = new ArrayList<Cab>();
		cabs.add(cab1);
		cabs.add(cab2);
		
		person.setCab(cabs);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityTransaction.commit();
	}

}
