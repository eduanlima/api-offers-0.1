package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.db.DB;
import br.com.model.dao.OfferDao;
import br.com.model.entities.Offer;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;
import br.com.model.entities.Store;

public class OfferDaoJDBC implements OfferDao{
	private static final String SELECT_ALL_BY_STORE = "SELECT product.id AS product_id, product.description AS description, "
													+ "product.sector AS sector_id, offer.price AS price, offer.image AS image, "
													+ "offer.date_initial AS date_initial, offer.date_limit AS date_limit, "
													+ "offer.status AS status "
													+ "FROM product, offer, store WHERE offer.status = true AND store.id = ? "
													+ "AND offer.store = store.id AND offer.product = product.id;  ";
	private Connection connection = null;
	
	public OfferDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Offer> findAllByStore(Integer id_store) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = new Store();
		store.setId(id_store);
		Sector sector;
		Product product;
		Offer offer;
		List<Offer> offers = new ArrayList<Offer>();
		
		try {
			query = connection.prepareStatement(SELECT_ALL_BY_STORE);
			query.setInt(1, store.getId());
			
			resultSet = query.executeQuery();
			
			while (resultSet.next()) {
				//Get sector
				sector = new Sector();
				sector.setId(resultSet.getInt("sector_id"));
				
				//Get dates product
				product = new Product();
				product.setId(resultSet.getInt("product_id"));
				product.setSector(sector);
				product.setDescription(resultSet.getString("description"));
				
				//Get dates offer
				offer = new Offer();
				offer.setStore(store);
				offer.setProduct(product);
				offer.setPrice(resultSet.getDouble("price"));
				offer.setImage(resultSet.getString("image"));
				offer.setDateInitial(resultSet.getDate("date_initial"));
				offer.setDateLimit(resultSet.getDate("date_limit"));
				offer.setStatus(resultSet.getBoolean("status"));
				
				offers.add(offer);
			}
			
			return offers;
			
		}
		catch(SQLException error) {
			throw new RuntimeException(error);
		}
		finally {
			DB.closeResultset(resultSet);
			DB.closeStatement(query);
			DB.closeConnection();
			DB.replaceConnection();
		}
	}

}
