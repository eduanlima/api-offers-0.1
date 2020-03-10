package br.com.model.dao;

import java.util.List;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;

public interface ProductDao {
	boolean insert(Product product);
	List<Product> findAll();
	List<Product> findAll(Sector sector);
}
