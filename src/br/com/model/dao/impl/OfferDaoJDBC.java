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
	private static final String SELECT_ALL_OFFER_BANNER = "SELECT store.name AS name, store.image AS store_image, offer_banner.store AS id_store, "
			+ "offer_banner.product AS id_product, offer_banner.description AS offer_description, price, image_min, date_initial, date_limit, "
			+ "mapped, sector.id AS sector "
			+ "FROM store, offer_banner, product, sector "
			+ "WHERE store.id = ? AND offer_banner.store = store.id AND offer_banner.mapped = true AND offer_banner.status = true AND"
			+ "product.id = offer_banner.product AND product.sector = sector.id "
			+ "ORDER BY price;";
	private Connection connection = null;
	
	public OfferDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Offer> findAllByStore(Integer id_store) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = null;
		Sector sector = null;
		Product product = null;
		Offer offer = null;
		List<Offer> offers = new ArrayList<Offer>();
		int store_id_aux = 0;
		
		try {
			query = connection.prepareStatement(SELECT_ALL_OFFER_BANNER);
			query.setInt(1, id_store);
			
			resultSet = query.executeQuery();
			
			while (resultSet.next()) {
				//Get datas store
				if (store_id_aux  == 0) {
					store_id_aux = resultSet.getInt("id_store");
					
					store = new Store();
					store.setId(store_id_aux );
					store.setName(resultSet.getString("name"));
					store.setImage(resultSet.getString("store_image"));
				}
				
				//Get sector
				sector = new Sector();
				sector.setId(resultSet.getInt("sector"));
				
				//Get datas product
				product = new Product();
				product.setId(resultSet.getInt("id_product"));
				product.setSector(sector);
				
				//Get datas offer
				offer = new Offer();
				offer.setStore(store);
				offer.setProduct(product);
				offer.setDescription(resultSet.getString("offer_description"));
				offer.setPrice(resultSet.getDouble("price"));
				offer.setImageMin(resultSet.getString("image_min"));
				offer.setDateInitial(resultSet.getDate("date_initial"));
				offer.setDateLimit(resultSet.getDate("date_limit"));
				offer.setMapped(resultSet.getBoolean("mapped"));
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
