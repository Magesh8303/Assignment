package com.demo.services.dao;

import java.util.List;

import com.demo.model.Address;
import com.demo.model.ResponseStatus;

public interface AddressServicesDAO {
	
	public ResponseStatus addAddress(List<Address> address);
	public ResponseStatus editAddress(List<Address> address);
	public ResponseStatus deleteAddress(int id);
	public ResponseStatus listAddress();

}
