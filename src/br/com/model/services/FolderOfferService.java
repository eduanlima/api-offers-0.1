package br.com.model.services;

import java.util.List;

import br.com.model.dao.DaoFactory;
import br.com.model.dao.FolderOfferDao;
import br.com.model.entities.FolderOffer;

public class FolderOfferService {
	private FolderOfferDao folderOfferDao = DaoFactory.createFolderOffer();
	
	public List<FolderOffer> findAll(Integer id_store){
		return folderOfferDao.findAll(id_store);
	}
}
