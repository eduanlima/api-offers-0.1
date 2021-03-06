package br.com.model.dao;

import br.com.db.DB;
import br.com.model.dao.impl.AddressDaoJDBC;
import br.com.model.dao.impl.BannerOfferDaoJDBC;
import br.com.model.dao.impl.BannerSliderDaoJDBC;
import br.com.model.dao.impl.FolderOfferDaoJDBC;
import br.com.model.dao.impl.OfferDaoJDBC;
import br.com.model.dao.impl.OfferSingleDaoJDBC;
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
	
	public static BannerSliderDao createBannerSlider() {
		return new BannerSliderDaoJDBC(DB.getConnection());
	}
	
	public static FolderOfferDao createFolderOffer() {
		return new FolderOfferDaoJDBC(DB.getConnection());
	}
	
	public static OfferSingleDao createOfferSingle() {
		return new OfferSingleDaoJDBC(DB.getConnection());
	}
}
