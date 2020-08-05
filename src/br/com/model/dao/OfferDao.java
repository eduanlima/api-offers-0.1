package br.com.model.dao;

import java.util.List;
import br.com.model.entities.Offer;

public interface OfferDao {
	List<Offer> findAllOfferBanner(Integer id_store);
	List<Offer> findAllOfferSingle(Integer id_store);
}
