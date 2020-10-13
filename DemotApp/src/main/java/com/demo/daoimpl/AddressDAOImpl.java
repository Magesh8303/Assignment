package com.demo.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.demo.dao.AddressDAO;
import com.demo.model.Address;
import com.demo.model.Person;

@Component
public class AddressDAOImpl implements AddressDAO {

	private String msg = null;

	private static final Logger logger = LogManager.getLogger(AddressDAOImpl.class);

	private Map<Integer, Address> addressMap = new HashMap<>();

	@Override
	public String addAddress(List<Address> addressList) {

		try {

			for (Address address : addressList) {

				if (!addressMap.containsKey(address.getId())) {
					addressMap.put(address.getId(), address);

				}

			}

			addressMap.entrySet().stream().forEach(entry -> logger.info("addAddress ->" + (entry.getValue())));

		} catch (Exception ex) {

			logger.error("Exception in addAddress", ex.getMessage());
		}

		return "Address Added Sucessfully";
	}

	@Override
	public String updateAddress(List<Address> addressList) {

		try {
			for (Address address : addressList) {

				if (addressMap.containsKey(address.getId())) {
					addressMap.put(address.getId(), address);
				}

			}

			addressMap.entrySet().stream().forEach(entry -> logger.info("editAddress ->" + (entry.getValue())));
		} catch (Exception ex) {

			logger.error("Exception in editAddress", ex.getMessage());
		}

		return "Address Edited Sucessfully";

	}

	@Override
	public String deleteAddress(int id) {

		try {

			if (addressMap.size() > 0) {
				addressMap.keySet().removeIf(key -> key == id);
				logger.info("========== After Address Deletion  =================");
				addressMap.entrySet().stream().forEach(entry -> logger.info("deleteAddress ->" + (entry.getValue())));
				logger.info("===================================================");

				msg = "Address Deleted Sucessfully";

			} else if (addressMap.isEmpty()) {
				msg = "Address Database is Empty";
			} else {

				msg = "No information found";
			}

		} catch (Exception ex) {

			logger.error("Exception in deleteAddress", ex.getMessage());
		}

		return msg;

	}

	@Override
	public List<Address> listAddress() {

		List<Address> list = null;

		try {

			list = addressMap.values().stream().collect(Collectors.toCollection(ArrayList::new));

			if (!list.isEmpty()) {

				list.stream().forEach(obj -> logger.info("Address Objects->" + obj));

			}
		} catch (Exception ex) {

			logger.error("Exception in deletePerson", ex.getMessage());
		}

		return list;
	}

}
