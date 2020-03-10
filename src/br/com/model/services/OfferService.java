package br.com.model.services;

import java.util.List;

import br.com.model.dao.DaoFactory;
import br.com.model.dao.OfferDao;
import br.com.model.entities.Offer;

public class OfferService {
	private OfferDao offerDao = DaoFactory.createOffer();
	
	public List<Offer> findAllByStore(Integer id_store) {
		return offerDao.findAllByStore(id_store);
	}
}
