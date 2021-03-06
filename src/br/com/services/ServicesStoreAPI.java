package br.com.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.model.entities.Store;
import br.com.model.services.StoreService;

@Path("/stores")
public class ServicesStoreAPI {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Store> findAll(){
		List<Store> stores;
		StoreService storeService = new StoreService();
		stores = storeService.findAll();
		return stores;
	}
	
	
	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Store find(@PathParam("id_store") Integer id_store){
		Store store;
		StoreService storeService = new StoreService();
		store = new Store();
		store = storeService.find(id_store);
		return store;
	}
}
