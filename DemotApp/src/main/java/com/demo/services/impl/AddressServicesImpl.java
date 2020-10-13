package com.demo.services.impl;


import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.daoimpl.AddressDAOImpl;
import com.demo.model.Address;
import com.demo.model.ResponseStatus;
import com.demo.services.dao.AddressServicesDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AddressServicesImpl implements AddressServicesDAO {

	private static final Logger logger = LogManager.getLogger(AddressServicesImpl.class);

	private AddressDAOImpl addressDAOImpl;
	private ResponseStatus responseStatus;

	private String msg = null;

	@Autowired
	public AddressServicesImpl(AddressDAOImpl addressDAOImpl,ResponseStatus responseStatus) {

		this.addressDAOImpl = addressDAOImpl;
		this.responseStatus= responseStatus;
	}

	@Override
	public ResponseStatus addAddress(List<Address> address) {

		try {
			msg = addressDAOImpl.addAddress(address);
			responseStatus.setCode(201);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("addAddress Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus editAddress(List<Address> address) {
		try {
			msg = addressDAOImpl.updateAddress(address);
			responseStatus.setCode(200);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("editAddress Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus deleteAddress(int id) {

		try {
			msg = addressDAOImpl.deleteAddress(id);
			responseStatus.setCode(200);
			responseStatus.setMessage(msg);
		} catch (Exception ex) {

			ex.printStackTrace();
			logger.error("deleteAddress Excepione->", ex);
			responseStatus.setCode(404);
			responseStatus.setMessage(ex.getMessage());
		}

		return responseStatus;
	}

	@Override
	public ResponseStatus listAddress() {
		
		List<Address> list = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			list = addressDAOImpl.listAddress();

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

}
