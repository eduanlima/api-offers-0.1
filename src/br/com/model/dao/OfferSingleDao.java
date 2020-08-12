package br.com.model.dao;

import java.util.List;
import br.com.model.entities.OfferSingle;

public interface OfferSingleDao {
	List<OfferSingle> findAll(Integer idStore);
}
