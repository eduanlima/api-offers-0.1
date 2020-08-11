package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.db.DB;
import br.com.model.dao.FolderOfferDao;
import br.com.model.entities.FolderOffer;

public class FolderOfferDaoJDBC implements FolderOfferDao{
	private static final String SELECT_ALL = "SELECT folder_offer.page AS page, folder_offer.image AS image "
			+ "FROM folder_offer, store "
			+ "WHERE store.id = ? AND store.id = folder_offer.store ORDER BY folder_offer.page;";
	private Connection connection = null;
	
	public FolderOfferDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<FolderOffer> findAll(Integer id){
		PreparedStatement query = null;
		ResultSet resultSet = null;
		
		try {
			query = connection.prepareStatement(SELECT_ALL);
			query.setInt(1, id);
			resultSet = query.executeQuery();
			
			List<FolderOffer> listFolders = new ArrayList<>();
			
			while (resultSet.next()) {
				FolderOffer folderOffer = new FolderOffer();
				folderOffer.setPage(resultSet.getInt("page"));
				folderOffer.setImage(resultSet.getString("image"));
				listFolders.add(folderOffer);
			}
			
			return listFolders;
			
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
