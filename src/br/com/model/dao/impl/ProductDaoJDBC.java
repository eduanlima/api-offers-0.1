package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.ProductDao;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;

public class ProductDaoJDBC implements ProductDao{
	
	private static final String INSERT_PRODUCT = "INSERT INTO product (description, image, sector) VALUES (?, ?, ?);";
	private static final String SELECT_ALL = "SELECT * FROM product;";
	private static final String SELECT_ALL_BY_SECTOR = "SELECT * FROM product WHERE sector = ?;";
	private Connection connection = null;
	
	public ProductDaoJDBC(Connection connection) {
		this.connection = connection;
		System.out.println("Connect product");
	}
	
	@Override
	public boolean insert(Product product) {
		boolean success = false;
		PreparedStatement query = null;
		
		try {
			connection.setAutoCommit(false);
			query = connection.prepareStatement(INSERT_PRODUCT);
			query.setString(1, product.getDescription());
			query.setString(2, product.getImage());
			query.setInt(3, product.getSector().getId());
			query.execute();
			connection.setAutoCommit(true);
			
			success = true;
			return success;
			
		} catch (SQLException error) {
			throw new RuntimeException(error);
		}
		finally {
			DB.closeStatement(query);
			DB.closeConnection();
			DB.replaceConnection();
		}	
	}
	
	public List<Product> findAll(){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			resultSet = query.executeQuery();
			
			List<Product> listProduct = new ArrayList<>();
			
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
				
				Sector sector = new Sector();
				sector.setId(resultSet.getInt("sector"));
				product.setSector(sector);
				listProduct.add(product);
			}
			
			return listProduct;
			
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
	
	public List<Product> findAll(Sector sector){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		
		try {
			query = connection.prepareStatement(SELECT_ALL_BY_SECTOR);
			query.setInt(1, sector.getId());
			resultSet = query.executeQuery();
			
			List<Product> listProduct = new ArrayList<>();
			
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
				
				sector = new Sector();
				sector.setId(resultSet.getInt("sector"));
				product.setSector(sector);
				listProduct.add(product);
			}
			
			return listProduct;
			
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
