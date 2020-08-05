package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.db.DB;
import br.com.model.dao.BannerSliderDao;
import br.com.model.entities.BannerSlider;
import br.com.model.entities.Store;

public class BannerSliderDaoJDBC implements BannerSliderDao{
	private static final String SELECT_ALL = "SELECT * FROM banner_slider WHERE store = ? AND status = true;";
	private Connection connection = null;
	
	public BannerSliderDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<BannerSlider> findAllByStore(Integer id_store) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = null;
		BannerSlider bannerSlider = null;
		List<BannerSlider> bannersSlider = new ArrayList<BannerSlider>();
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			query.setInt(1, id_store);
			resultSet = query.executeQuery();
			
			while(resultSet.next()) {
				if (store == null) {
					store = new Store();
					store.setId(resultSet.getInt("store"));
				}
				
				bannerSlider = new BannerSlider();
				bannerSlider.setId(resultSet.getInt("id"));
				bannerSlider.setStore(store);
				bannerSlider.setImage(resultSet.getString("image"));
				bannerSlider.setStatus(resultSet.getBoolean("status"));
				
				bannersSlider.add(bannerSlider);
			}
			
			return bannersSlider;
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
