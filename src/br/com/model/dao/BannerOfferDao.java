package br.com.model.dao;

import java.util.List;

import br.com.model.entities.BannerOffer;

public interface BannerOfferDao {
	List<BannerOffer> findAllByStore(Integer id_store);
}
