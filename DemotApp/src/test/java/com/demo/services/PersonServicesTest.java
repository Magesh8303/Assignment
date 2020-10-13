package com.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.demo.DemoAppApplicationTests;
import com.demo.model.Person;
import com.demo.model.ResponseStatus;
import com.demo.services.impl.PersonServicesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonServicesTest extends DemoAppApplicationTests {

	private static final Logger logger = LogManager.getLogger(PersonServicesTest.class);

	@Autowired
	private PersonServicesImpl personServicesImpl;

	@Autowired
	private ResponseStatus responseStatus;

	private String msg = null;

	@Test
	@Order(1)
	public void addPesonTest() {

		Person person = new Person();

		person.setId(1);
		person.setFirstName("Magesh");
		person.setLastName("Kumar");

		Person person1 = new Person();

		person1.setId(2);
		person1.setFirstName("Magesh");
		person1.setLastName("Kumar");

		List<Person> listObj = new ArrayList<>();

		listObj.add(person);
		listObj.add(person1);

		try {

			responseStatus = personServicesImpl.addPerson(listObj);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals(responseStatus.getMessage(), "Person Added Sucessfully");

	}

	@Test
	@Order(2)
	public void duplicatePesonTest() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("Magesh");
		person.setLastName("Kumar");

		Person person1 = new Person();
		person1.setId(1);
		person1.setFirstName("Magesh");
		person1.setLastName("Kumar");

		List<Person> listObj = new ArrayList<>();

		listObj.add(person);
		listObj.add(person1);

		try {

			responseStatus = personServicesImpl.addPerson(listObj);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals("Person Added Sucessfully", responseStatus.getMessage());

	}

	@Test
	@Order(3)
	public void editPersonTest() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("Magesh");
		person.setLastName("Kumar");

		Person person2 = new Person();
		person2.setId(2);
		person2.setFirstName("Magesh2");
		person2.setLastName("Kumar2");


		List<Person> listObj = new ArrayList<>();
		listObj.add(person);
		listObj.add(person2);

		try {

			responseStatus = personServicesImpl.addPerson(listObj);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		Person person1 = new Person();
		person1.setId(2);
		person1.setFirstName("Magesh");
		person1.setLastName("Kumar");

		List<Person> listObj1 = new ArrayList<>();
		listObj1.add(person1);

		try {
			responseStatus = personServicesImpl.editPerson(listObj1);
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals("Person Edited Sucessfully", responseStatus.getMessage());
	}

	@Test
	@Order(4)
	public void deletePersonTest() {

		try {

			responseStatus = personServicesImpl.deletePerson(2);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals("Person Deleted Sucessfully", responseStatus.getMessage());

	}

	@Test
	@Order(5)
	public void listPersonTest() {

		List<Person> list = null;

		try {

			responseStatus = personServicesImpl.listPerson();
			
			logger.info(responseStatus.getMessage());
			
			ObjectMapper om = new ObjectMapper();
			
			list = Arrays.asList(om.readValue(responseStatus.getMessage(), Person[].class));

			list.stream().forEach(obj -> logger.info(obj));

		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}
	
	


}
