package br.com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.entities.Offer;
import br.com.model.services.OfferService;

@Path("/offers")
public class ServiceOfferAPI {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Offer> findAllOffers(@PathParam("id_store") Integer id_store) {
		List<Offer> offers = new ArrayList<Offer>();
		OfferService serviceOffer;
		serviceOffer = new OfferService();
		offers = serviceOffer.findAllOfferBanner(id_store);
		
		serviceOffer = new OfferService();
		offers.addAll(serviceOffer.findAllOfferSingle(id_store));
		return offers;
	}
}
