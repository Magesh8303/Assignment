package com.demo.dao;

import java.util.List;

import com.demo.model.Address;

public interface AddressDAO {

	public String addAddress(List<Address> address);

	public String updateAddress(List<Address> address);

	public String deleteAddress(int id);

	public List<Address> listAddress();

}
