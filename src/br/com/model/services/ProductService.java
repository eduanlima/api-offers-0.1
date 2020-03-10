package br.com.model.services;

import java.util.List;
import br.com.model.dao.DaoFactory;
import br.com.model.dao.ProductDao;
import br.com.model.entities.Product;
import br.com.model.entities.Sector;

public class ProductService {
	private ProductDao productDao = DaoFactory.createProduct();
	
	public boolean insert(Product product) {
		return productDao.insert(product);
	}
	
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	public List<Product> findAll(Sector sector){
		return productDao.findAll(sector);
	}
}
