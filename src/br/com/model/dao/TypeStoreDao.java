package br.com.model.dao;

import java.util.List;
import br.com.model.entities.TypeStore;

public interface TypeStoreDao {
	List<TypeStore> findAll();
}
