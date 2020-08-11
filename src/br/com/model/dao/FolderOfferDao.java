package br.com.model.dao;

import java.util.List;

import br.com.model.entities.FolderOffer;

public interface FolderOfferDao {
	List<FolderOffer> findAll(Integer id_store);
}
