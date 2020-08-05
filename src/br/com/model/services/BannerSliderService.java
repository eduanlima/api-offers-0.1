package br.com.model.services;

import java.util.List;
import br.com.model.dao.BannerSliderDao;
import br.com.model.dao.DaoFactory;
import br.com.model.entities.BannerSlider;

public class BannerSliderService {
	private BannerSliderDao bannerSliderDao = DaoFactory.createBannerSlider();
	
	public List<BannerSlider> findAllByStore(Integer id_store){
		return bannerSliderDao.findAllByStore(id_store);
	}
}
