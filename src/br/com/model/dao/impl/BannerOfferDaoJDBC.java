package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.db.DB;
import br.com.model.dao.BannerOfferDao;
import br.com.model.entities.BannerOffer;
import br.com.model.entities.Sector;
import br.com.model.entities.Store;


public class BannerOfferDaoJDBC implements BannerOfferDao{
	
	private static final String SELECT_ALL = "SELECT * FROM banner_offer WHERE store = ?;";
	private Connection connection = null;
	
	public BannerOfferDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<BannerOffer> findAllByStore(Integer id_store) {
		PreparedStatement query = null;
		ResultSet resultSet = null;
		Store store = null;
		Sector sector = null;
		BannerOffer bannerOffer = null;
		List<BannerOffer> bannersOffer = new ArrayList<BannerOffer>();
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			query.setInt(1, id_store);
			resultSet = query.executeQuery();
			
			while(resultSet.next()) {
				if (store == null) {
					store = new Store();
					store.setId(resultSet.getInt("store"));
				}
				
				sector = new Sector();
				sector.setId(resultSet.getInt("sector"));
				
				bannerOffer = new BannerOffer();
				bannerOffer.setStore(store);
				bannerOffer.setSector(sector);
				bannerOffer.setImage(resultSet.getString("image"));
				bannerOffer.setDateInitial(resultSet.getDate("date_initial"));
				bannerOffer.setDateLimit(resultSet.getDate("date_limit"));
				bannerOffer.setStatus(resultSet.getBoolean("status"));
				
				bannersOffer.add(bannerOffer);
			}
			
			return bannersOffer;
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
