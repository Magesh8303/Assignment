package com.demo.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.demo.dao.PersonDAO;
import com.demo.model.Person;

@Component
public class PersonDAOImpl implements PersonDAO {

	private String msg = null;

	private static final Logger logger = LogManager.getLogger(PersonDAOImpl.class);

	private Map<Integer, Person> personMap = new HashMap<>();

	@Override
	public String addPerson(List<Person> personList) {

		try {

			for (Person pr : personList) {

				if (!personMap.containsKey(pr.getId())) {

					personMap.put(pr.getId(), pr);

				}

			}

			personMap.entrySet().stream().forEach(entry -> logger.info("addPerson ->" + (entry.getValue())));

		} catch (Exception ex) {

			logger.error("Exception in addPerson", ex.getMessage());
		}

		return "Person Added Sucessfully";

	}

	@Override
	public String updatePerson(List<Person> personList) {

		try {
			for (Person pr : personList) {

				if (personMap.containsKey(pr.getId())) {
					personMap.put(pr.getId(), pr);
				}

			}

			personMap.entrySet().stream().forEach(entry -> logger.info("editPerson ->" + (entry.getValue())));
		} catch (Exception ex) {

			logger.error("Exception in editPerson", ex.getMessage());
		}

		return "Person Edited Sucessfully";
	}

	@Override
	public String deletePerson(int id) {

		try {

			if (personMap.size() > 0) {
				personMap.keySet().removeIf(key -> key == id);
				logger.info("========== After Person Deletion  =================");
				personMap.entrySet().stream().forEach(entry -> logger.info("deletePerson ->" + (entry.getValue())));
				logger.info("===================================================");

				msg = "Person Deleted Sucessfully";

			} else if (personMap.isEmpty()) {
				msg = "Person Database is Empty";
			} else {

				msg = "No information found";
			}

		} catch (Exception ex) {

			logger.error("Exception in deletePerson", ex.getMessage());
		}

		return msg;

	}

	@Override
	public List<Person> listPerson() {

		List<Person> list = null;

		try {

			list = personMap.values().stream().collect(Collectors.toCollection(ArrayList::new));

			if (!list.isEmpty()) {

				list.stream().forEach(obj -> logger.info("Person Object->" + obj));

			}
		} catch (Exception ex) {

			logger.error("Exception in deletePerson", ex.getMessage());
		}

		return list;

	}

	@Override
	public int countOfPersons() {
		
		
		return personMap.size();
	}

}
