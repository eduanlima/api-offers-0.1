package br.com.model.dao;

import br.com.db.DB;
import br.com.model.dao.impl.AddressDaoJDBC;
import br.com.model.dao.impl.BannerOfferDaoJDBC;
import br.com.model.dao.impl.OfferDaoJDBC;
import br.com.model.dao.impl.ProductDaoJDBC;
import br.com.model.dao.impl.SectorDaoJDBC;
import br.com.model.dao.impl.StoreDaoJDBC;
import br.com.model.dao.impl.TypeStoreDaoJDBC;

public class DaoFactory {
	public static SectorDao createSectorDao() {
		return new SectorDaoJDBC(DB.getConnection());
	}
	
	public static ProductDao createProduct() {
		return new ProductDaoJDBC(DB.getConnection());
	}
	
	public static TypeStoreDao createTypeStore() {
		return new TypeStoreDaoJDBC(DB.getConnection());
	}
	
	public static StoreDao createStore() {
		return new StoreDaoJDBC(DB.getConnection());
	}
	
	public static AddressDao createAddress() {
		return new AddressDaoJDBC(DB.getConnection());
	}
	
	public static BannerOfferDao createBannerOffer() {
		return new BannerOfferDaoJDBC(DB.getConnection());
	}
	
	public static OfferDao createOffer() {
		return new OfferDaoJDBC(DB.getConnection());
	}
}
