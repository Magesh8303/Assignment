package com.demo.dao;

import java.util.List;

import com.demo.model.Person;

public interface PersonDAO {

	public String addPerson(List<Person> person);
	public String updatePerson(List<Person> person);
	public String deletePerson(int id);
	public List<Person> listPerson();
	public int countOfPersons();

}
