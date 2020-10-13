package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Address;
import com.demo.model.Person;
import com.demo.model.ResponseStatus;
import com.demo.services.impl.AddressServicesImpl;
import com.demo.services.impl.PersonServicesImpl;
import com.demo.validator.PersonValidator;

@RestController
@RequestMapping("/demo")
@Validated
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	private ResponseStatus msg;

	@Autowired
	private PersonServicesImpl personServicesImpl;
	
	
	@GetMapping("/test")
	public String test() {

		logger.info("Application Started");
		return "Application Started";

	}

	@PostMapping(path = "/addperson", consumes = "application/json")
	 public ResponseEntity<ResponseStatus> addPerson(@RequestBody  List<@Valid Person> person) {
	 

		try {
			 msg = personServicesImpl.addPerson(person);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Exception in addPerson", ex);
		}

		return new ResponseEntity<>(msg, HttpStatus.CREATED);

	}

	@PutMapping(path = "/editperson", consumes = "application/json")
	public ResponseEntity<ResponseStatus> editPerson(@RequestBody List<Person> person) {

		try {
			msg = personServicesImpl.editPerson(person);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Exception in addPerson", ex);
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@GetMapping(path = "/listperson", produces = "application/json")
	public ResponseEntity<ResponseStatus> listPerson() {

		return new ResponseEntity<>(personServicesImpl.listPerson(), HttpStatus.OK);

	}

	@DeleteMapping(path = "/deleteperson/{id}")
	public ResponseEntity<ResponseStatus> deletePerson(@PathVariable("id") int id) {

		return new ResponseEntity<>(personServicesImpl.deletePerson(id), HttpStatus.OK);

	}
	
	@GetMapping(path = "/personcount")
	public ResponseEntity<ResponseStatus> countofPerson() {

		return new ResponseEntity<>(personServicesImpl.countPerson(), HttpStatus.OK);

	}

}
