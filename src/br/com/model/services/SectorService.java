package br.com.model.services;

import java.util.List;
import br.com.model.dao.DaoFactory;
import br.com.model.dao.SectorDao;
import br.com.model.entities.Sector;


public class SectorService {
	private SectorDao sectorDao = DaoFactory.createSectorDao();
	
	public List<Sector> findAll(){
		return sectorDao.findAll();
	}
}
