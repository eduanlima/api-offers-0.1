package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.SectorDao;
import br.com.model.entities.Sector;

public class SectorDaoJDBC implements SectorDao{
	
	private static final String SELECT_ALL = "SELECT * FROM sector;";
	
	private Connection connection = null;
	
	public SectorDaoJDBC(Connection connection) {
		this.connection = connection;
		System.out.println("Connect sector");
	}
	
	@Override
	public List<Sector> findAll(){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(SELECT_ALL);
			resultSet = statement.executeQuery();
			
			List<Sector> listSector = new ArrayList<>();
			
			while (resultSet.next()) {
				Sector sector = new Sector();
				sector.setId(resultSet.getInt("id"));
				sector.setDescription(resultSet.getString("description"));
				listSector.add(sector);
			}
			
			return listSector;
			
		} catch(SQLException error) {
			throw new RuntimeException(error.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeResultset(resultSet);
			DB.closeConnection();
			DB.replaceConnection();
		}
	}
	
}
