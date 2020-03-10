package br.com.model.dao;

import java.util.List;
import br.com.model.entities.Store;

public interface StoreDao {
	Store find(Integer store_id);
	Store findWithOffers(Integer store_id);
	List<Store> findAll();
}

