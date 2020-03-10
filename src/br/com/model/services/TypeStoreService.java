package br.com.model.services;

import java.util.List;
import br.com.model.dao.DaoFactory;
import br.com.model.dao.TypeStoreDao;
import br.com.model.entities.TypeStore;


public class TypeStoreService {
	private TypeStoreDao typeStoreDao = DaoFactory.createTypeStore();
	
	public List<TypeStore> findAll(){
		return typeStoreDao.findAll();
	}
}
