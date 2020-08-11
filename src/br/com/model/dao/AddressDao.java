package br.com.model.dao;

import java.util.List;

import br.com.model.entities.Address;

public interface AddressDao {
	Address findById(Integer id);
	List<Address> findAll();
}
