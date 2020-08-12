package br.com.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.model.entities.OfferSingle;
import br.com.model.services.OfferSingleService;

@Path("/offersingle")
public class ServiceOfferSingleAPI {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<OfferSingle> findAll(@PathParam("id_store") Integer idStore){
		List<OfferSingle> offers;
		OfferSingleService offerSingleService = new OfferSingleService();
		offers = offerSingleService.findAll(idStore);
		return offers;
	}
}
