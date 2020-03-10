package br.com.model.services;

import java.util.List;

import br.com.model.dao.BannerOfferDao;
import br.com.model.dao.DaoFactory;
import br.com.model.entities.BannerOffer;

public class BannerOfferService {
	private BannerOfferDao bannerOfferDao = DaoFactory.createBannerOffer();
	
	public List<BannerOffer> findAllByStore(Integer id_store){
		return bannerOfferDao.findAllByStore(id_store);
	}
}
