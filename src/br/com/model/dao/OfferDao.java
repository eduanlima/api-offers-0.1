package br.com.model.dao;

import java.util.List;
import br.com.model.entities.Offer;

public interface OfferDao {
	List<Offer> findAllByStore(Integer id_store);
}
