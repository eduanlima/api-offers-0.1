package br.com.model.dao;

import java.util.List;

import br.com.model.entities.BannerSlider;

public interface BannerSliderDao {
	List<BannerSlider> findAllByStore(Integer id_store); 
}
