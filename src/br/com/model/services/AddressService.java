package br.com.model.services;

import java.util.List;

import br.com.model.dao.AddressDao;
import br.com.model.dao.DaoFactory;
import br.com.model.entities.Address;

public class AddressService {
	private AddressDao addressDao = DaoFactory.createAddress();
	
	public List<Address>findAll() {
		return addressDao.findAll();
	}
}
