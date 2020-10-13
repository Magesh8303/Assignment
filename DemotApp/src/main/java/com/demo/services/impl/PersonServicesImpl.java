package com.demo.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.daoimpl.PersonDAOImpl;
import com.demo.model.Person;
import com.demo.model.ResponseStatus;
import com.demo.services.dao.PeronServicesDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonServicesImpl implements PeronServicesDAO {

	private static final Logger logger = LogManager.getLogger(PersonServicesImpl.class);

	private PersonDAOImpl personDAOImpl;
	private ResponseStatus responseStatus;

	String msg = null;

	@Autowired
	PersonServicesImpl(PersonDAOImpl personDAOImpl, ResponseStatus responseStatus) {

		this.personDAOImpl = personDAOImpl;
		this.responseStatus = responseStatus;
	}

	@Override
	public ResponseStatus addPerson(List<Person> person) {

		try {
			msg = personDAOImpl.addPerson(person);
			responseStatus.setCode(201);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("addPerson Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus editPerson(List<Person> person) {

		try {
			msg = personDAOImpl.updatePerson(person);
			responseStatus.setCode(200);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("editPerson Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus deletePerson(int id) {

		try {
			msg = personDAOImpl.deletePerson(id);
			responseStatus.setCode(200);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("deletePerson Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus listPerson() {

		List<Person> list = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			list = personDAOImpl.listPerson();

			if (!list.isEmpty()) {

				msg = objectMapper.writeValueAsString(list);
				responseStatus.setCode(200);
				responseStatus.setMessage(msg);
			} else {

				msg = objectMapper.writeValueAsString("No Information found");
				responseStatus.setCode(200);
				responseStatus.setMessage(msg);
			}

		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("listPerson Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus countPerson() {

		try {

			int count = personDAOImpl.countOfPersons();
			if (count == 0) {

				responseStatus.setCode(200);
				responseStatus.setMessage("No information found");

			} else {
				responseStatus.setCode(200);
				responseStatus.setMessage(count + " Persons information found in database ");
			}

		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("listPerson Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

}
