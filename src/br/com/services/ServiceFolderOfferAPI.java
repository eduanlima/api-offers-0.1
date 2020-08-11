package br.com.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.model.entities.FolderOffer;
import br.com.model.services.FolderOfferService;

@Path("/folders")
public class ServiceFolderOfferAPI {
	private static final String CHARSET_UTF8 = ";charset=utf-8";

	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<FolderOffer> findAll(@PathParam("id_store") Integer id_store){
		List<FolderOffer> folders;
		FolderOfferService folderOfferService = new FolderOfferService();
		folders = folderOfferService.findAll(id_store);	
		return folders;
	}
	
}
