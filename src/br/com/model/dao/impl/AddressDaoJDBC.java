package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.db.DB;
import br.com.model.dao.AddressDao;
import br.com.model.entities.Address;


public class AddressDaoJDBC implements AddressDao{
	
	private static final String SELECT_ALL = "SELECT * FROM address;";
	private Connection connection = null;
	
	public AddressDaoJDBC (Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Address> findAll() {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Address address = null;
		List<Address> addresses = new ArrayList<Address>();
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			resultSet = query.executeQuery();
			
			while(resultSet.next()) {
				address = new Address();
				address.setId(resultSet.getInt("id"));
				address.setAddress(resultSet.getString("address"));
				address.setLatitude(resultSet.getDouble("latitude"));
				address.setLongitude(resultSet.getDouble("longitude"));
				
				addresses.add(address);
			}
			
			return addresses;
		}
		catch(SQLException error) {
			throw new RuntimeException(error);
		}
		finally {
			DB.closeStatement(query);
			DB.closeResultset(resultSet);
			DB.closeConnection();
			DB.replaceConnection();
		}
	}
	
}
