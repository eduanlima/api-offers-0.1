package br.com.model.dao;

import java.util.List;
import br.com.model.entities.Sector;

public interface SectorDao {
	List<Sector> findAll();
}
