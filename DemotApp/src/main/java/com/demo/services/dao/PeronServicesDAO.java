package com.demo.services.dao;

import java.util.List;

import com.demo.model.Person;
import com.demo.model.ResponseStatus;

public interface PeronServicesDAO {
	
	public ResponseStatus addPerson(List<Person> person);
	public ResponseStatus editPerson(List<Person> person);
	public ResponseStatus deletePerson(int id);
	public ResponseStatus listPerson();
	public ResponseStatus countPerson();

}
