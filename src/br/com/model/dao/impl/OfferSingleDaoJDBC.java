package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.OfferSingleDao;
import br.com.model.entities.OfferSingle;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;
import br.com.model.entities.Store;

public class OfferSingleDaoJDBC implements OfferSingleDao{
	
	private static final String SELECT_ALL= "SELECT offer_single.store AS store, offer_single.product AS product_id,\r\n" + 
			"sector.id AS sector_id, sector.description AS desc_sector,\r\n" + 
			"offer_single.title AS title, offer_single.description AS desc_offer,\r\n" + 
			"offer_single.image AS image, offer_single.image_min AS image_min,\r\n" + 
			"offer_single.date_initial AS date_initial, offer_single.date_limit AS date_limit,\r\n" + 
			"offer_single.mapped AS mapped FROM offer_single, product, sector\r\n" + 
			"WHERE offer_single.store = ? AND offer_single.product = product.id AND\r\n" + 
			"product.sector = sector.id;";
	
	private Connection connection = null;
	
	public OfferSingleDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<OfferSingle> findAll(Integer idStore) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Sector sector = null;
		Product product = null;
		OfferSingle offerSingle = null;
		Store store = new Store();
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			query.setInt(1, idStore);
			resultSet = query.executeQuery();
			
			List<OfferSingle> listOffer = new ArrayList<OfferSingle>();
			
			while (resultSet.next()) {
				
				if (store.getId() == null) {
					store.setId(resultSet.getInt("store"));
				}
				
				sector = new Sector(
						resultSet.getInt("sector_id"), 
						resultSet.getString("desc_sector")
						);
				
				product = new Product();
				product.setId(resultSet.getInt("product_id"));
				product.setSector(sector);
				
				offerSingle = new OfferSingle();
				offerSingle.setStore(store);
				offerSingle.setProduct(product);
				offerSingle.setTitle(resultSet.getString("title"));
				offerSingle.setDescription(resultSet.getString("desc_offer"));
				offerSingle.setImage(resultSet.getString("image"));
				offerSingle.setImageMin(resultSet.getString("image_min"));
				offerSingle.setDateInitial(resultSet.getDate("date_initial"));
				offerSingle.setDateLimit(resultSet.getDate("date_limit"));
				offerSingle.setMapped(resultSet.getBoolean("mapped"));
				
				listOffer.add(offerSingle);
			}
			
			return listOffer;
			
		} catch (SQLException error) {
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
