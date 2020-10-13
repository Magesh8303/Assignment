package com.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.DemoAppApplicationTests;
import com.demo.model.Address;
import com.demo.model.ResponseStatus;
import com.demo.services.impl.AddressServicesImpl;
 

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServicesTest extends DemoAppApplicationTests {

	@Autowired
	private AddressServicesImpl addressServicesImpl;
	
	@Autowired
	private ResponseStatus  responseStatus;
	
	@Test
	@Order(1)
	public void addAddressTest() {

		Address address = new Address();

		address.setId(1);
		address.setStreet("74B");
		address.setCity("Coimbatore");
		address.setPostalCode("641659");
		address.setState("TamilNadu");

		Address address1 = new Address();

		address1.setId(2);
		address1.setStreet("74-B");
		address1.setCity("Chennai");
		address1.setPostalCode("641659");
		address1.setState("TamilNadu");
		
		List<Address> setAddress = new ArrayList<Address>();


		setAddress.add(address);
		setAddress.add(address1);

		try {

			responseStatus = addressServicesImpl.addAddress(setAddress);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals(responseStatus.getMessage(), "Address Added Sucessfully");

	}
	
	
	@Test
	@Order(2)
	public void duplicateAddressTest() {

		Address address = new Address();

		address.setId(1);
		address.setStreet("74B");
		address.setCity("Coimbatore");
		address.setPostalCode("641659");
		address.setState("TamilNadu");

		Address address1 = new Address();

		address1.setId(1);
		address1.setStreet("74-B");
		address1.setCity("Chennai");
		address1.setPostalCode("641659");
		address1.setState("TamilNadu");
		
		List<Address> setAddress = new ArrayList<Address>();


		setAddress.add(address);
		setAddress.add(address1);

		try {

			responseStatus = addressServicesImpl.addAddress(setAddress);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals(responseStatus.getMessage(), "Address Added Sucessfully");

	}
	
	
	@Test
	@Order(3)
	public void editAddressTest() {

		Address address = new Address();

		address.setId(1);
		address.setStreet("74B");
		address.setCity("Coimbatore");
		address.setPostalCode("641659");
		address.setState("TamilNadu");

		Address address1 = new Address();

		address1.setId(1);
		address1.setStreet("74-B");
		address1.setCity("Chennai");
		address1.setPostalCode("641659");
		address1.setState("TamilNadu");
		
		List<Address> setAddress = new ArrayList<Address>();


		setAddress.add(address);
		setAddress.add(address1);

		try {

			responseStatus = addressServicesImpl.editAddress(setAddress);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals(responseStatus.getMessage(), "Address Edited Sucessfully");

	}
	
	@Test
	@Order(4)
	public void deleteAddressTest() {

		try {

			responseStatus = addressServicesImpl.deleteAddress(2);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		assertEquals("Address Deleted Sucessfully", responseStatus.getMessage());

	}

}
