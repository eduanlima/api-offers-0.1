package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.TypeStoreDao;
import br.com.model.entities.TypeStore;

public class TypeStoreDaoJDBC implements TypeStoreDao{
	private Connection connection = null;
	
	public TypeStoreDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<TypeStore> findAll(){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		
		try {
			query = connection.prepareStatement("SELECT * FROM type_store;");
			resultSet = query.executeQuery();
			
			List<TypeStore> listTypeStore = new ArrayList<>();
			
			while (resultSet.next()) {
				TypeStore typeStore = new TypeStore();
				typeStore.setId(resultSet.getInt("id"));
				typeStore.setDescription(resultSet.getString("description"));
				listTypeStore.add(typeStore);
			}
			
			return listTypeStore;
		}
		catch (SQLException error) {
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
