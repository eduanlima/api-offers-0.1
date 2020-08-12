package br.com.model.services;

import java.util.List;
import br.com.model.dao.DaoFactory;
import br.com.model.dao.OfferSingleDao;
import br.com.model.entities.OfferSingle;

public class OfferSingleService {
	private OfferSingleDao offerSingleDao = DaoFactory.createOfferSingle();
	
	public List<OfferSingle> findAll(Integer idStore){
		return offerSingleDao.findAll(idStore);
	}
}
