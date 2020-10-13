package com.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping("/demo")
public class AddressController {

	private static final Logger logger = LogManager.getLogger(AddressController.class);

	@Autowired
	private ResponseStatus msg;

	@Autowired
	private AddressServicesImpl addressServicesImpl;
	
	@PostMapping(path = "/addaddress", consumes = "application/json")
	public ResponseEntity<ResponseStatus> addAddress(@RequestBody List<Address> address) {
		
		logger.info("addAddress initatied");
		try {
			msg =  addressServicesImpl.addAddress(address);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Exception in addAddress", ex);
		}

		return new ResponseEntity<ResponseStatus>(msg, HttpStatus.CREATED);

	}
	
	@PutMapping(path = "/editaddress", consumes = "application/json")
	public ResponseEntity<ResponseStatus> editAddress(@RequestBody List<Address> address) {

		try {
			msg= addressServicesImpl.editAddress(address);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Exception in addPerson", ex);
		}

		return new ResponseEntity<ResponseStatus>(msg, HttpStatus.OK);

	}

	@GetMapping(path = "/listaddress", produces = "application/json")
	public ResponseEntity<ResponseStatus> listAddress() {

		return new ResponseEntity<ResponseStatus>(addressServicesImpl.listAddress(), HttpStatus.OK);

	}

	@DeleteMapping(path = "/deleteaddress/{id}")
	public ResponseEntity<ResponseStatus> deleteAddress(@PathVariable("id") int id) {

		return new ResponseEntity<ResponseStatus>(addressServicesImpl.deleteAddress(id),HttpStatus.OK);

	}

}
