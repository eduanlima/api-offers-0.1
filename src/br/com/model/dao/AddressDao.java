package br.com.model.dao;

import java.util.List;

import br.com.model.entities.Address;

public interface AddressDao {
	List<Address> findAll();
}
