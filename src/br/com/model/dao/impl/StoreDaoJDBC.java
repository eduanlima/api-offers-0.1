package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.db.DB;
import br.com.model.dao.StoreDao;
import br.com.model.entities.Offer;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;
import br.com.model.entities.Store;
import br.com.model.entities.TypeStore;

public class StoreDaoJDBC implements StoreDao{
	private static final String SELECT_ALL = "SELECT * FROM store;";
	private static final String SELECT_ONE = "SELECT * FROM store WHERE id = ?";
	private static final String SELECT_WITH_OFFERS = "SELECT store.id AS store_id, store.name AS name, store.image AS store_image, "
														+ "product.id AS product_id, product.description AS description, "
														+ "product.sector AS sector_id, offer.price AS price, offer.image AS offer_image, "
														+ "offer.date_initial AS date_initial, offer.date_limit AS date_limit, "
														+ "offer.status AS status "
														+ "FROM product, offer, store WHERE offer.status = true AND store.id = ? "
														+ "AND offer.store = store.id AND offer.product = product.id;  ";
	private Connection connection = null;
	
	public StoreDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Store find(Integer store_id){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = null;
		
		try {
			query = connection.prepareStatement(SELECT_ONE);
			query.setInt(1, store_id);
			resultSet = query.executeQuery();
			
			while (resultSet.next()) {
				store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setName(resultSet.getString("name"));
				store.setImage(resultSet.getString("image"));
				store.setType(new TypeStore(resultSet.getInt("type_store"), null));
			}
			
			return store;
			
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
	
	@Override
	public List<Store> findAll(){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			resultSet = query.executeQuery();
			
			List<Store> listStore = new ArrayList<>();
			
			while (resultSet.next()) {
				Store store = new Store();
				store.setId(resultSet.getInt("id"));
				store.setName(resultSet.getString("name"));
				listStore.add(store);
			}
			
			return listStore;
			
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

	@Override
	public Store findWithOffers(Integer store_id) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = null;
		Sector sector = null;
		Product product = null;
		Offer offer = null;
		List<Offer> offers = new ArrayList<Offer>();
		int store_id_aux = 0;
		
		try {
			query = connection.prepareStatement(SELECT_WITH_OFFERS);
			query.setInt(1, store_id);
			
			resultSet = query.executeQuery();
			
			while (resultSet.next()) {
				//Get datas store
				if (store_id_aux  == 0) {
					store_id_aux = resultSet.getInt("store_id");
					
					store = new Store();
					store.setId(store_id_aux );
					store.setName(resultSet.getString("name"));
					store.setImage(resultSet.getString("store_image"));
				}
				
				//Get sector
				sector = new Sector();
				sector.setId(resultSet.getInt("sector_id"));
				
				//Get datas product
				product = new Product();
				product.setId(resultSet.getInt("product_id"));
				product.setSector(sector);
				product.setDescription(resultSet.getString("description"));
				
				//Get datas offer
				offer = new Offer();
				offer.setStore(store);
				offer.setProduct(product);
				offer.setPrice(resultSet.getDouble("price"));
				offer.setImage(resultSet.getString("offer_image"));
				offer.setDateInitial(resultSet.getDate("date_initial"));
				offer.setDateLimit(resultSet.getDate("date_limit"));
				offer.setStatus(resultSet.getBoolean("status"));
				
				offers.add(offer);
				
			}
			
			//store.setOffers(offers);
			
			return store;
			
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
