package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.StoreDao;
import br.com.model.entities.Store;
import br.com.model.entities.TypeStore;

public class StoreDaoJDBC implements StoreDao{
	private static final String SELECT_ALL = "SELECT * FROM store;";
	private static final String SELECT_ONE = "SELECT * FROM store WHERE id = ?";
	private static final String SELECT_WITH_OFFER_BANNER = "SELECT store.name AS name, store.image AS store_image, offer_banner.store AS id_store, "
			+ "offer_banner.product AS id_product, offer_banner.description AS offer_description, price, image_min, date_initial, date_limit, "
			+ "mapped, sector.id AS sector "
			+ "FROM store, offer_banner, product, sector "
			+ "WHERE store.id = ? AND offer_banner.store = store.id AND offer_banner.mapped = true AND offer_banner.status = true AND"
			+ "product.id = offer_banner.product AND product.sector = sector.id "
			+ "ORDER BY price;";
	private static final String SELECT_WITH_OFFER_SINGLE = "SELECT store.name AS name, store.image AS store_image, offer_single.store AS id_store, "
			+ "offer_single.product AS id_product, offer_single.description AS offer_description, price, image_min, date_initial, date_limit, "
			+ "mapped, sector.id AS sector "
			+ "FROM store, offer_single, product, sector "
			+ "WHERE store.id = ? AND offer_single.store = store.id AND offer_single.mapped = true AND offer_single.status = true AND"
			+ "product.id = offer_single.product AND product.sector = sector.id "
			+ "ORDER BY price;";
	
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
				store.setImage(resultSet.getString("image"));
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

}
