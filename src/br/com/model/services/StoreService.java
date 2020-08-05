package br.com.model.services;

import java.util.List;
import br.com.model.dao.DaoFactory;
import br.com.model.dao.StoreDao;
import br.com.model.entities.Store;

public class StoreService {
	private StoreDao storeDao = DaoFactory.createStore();
	
	public Store find(Integer store_id) {
		return storeDao.find(store_id);
	}
	
	public List<Store> findAll(){
		return storeDao.findAll();
	}
}
