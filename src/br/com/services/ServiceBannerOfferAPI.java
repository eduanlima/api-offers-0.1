package br.com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.entities.BannerOffer;
import br.com.model.services.BannerOfferService;

@Path("/banners")
public class ServiceBannerOfferAPI {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<BannerOffer> findAll(@PathParam("id_store") Integer id_store){
		List<BannerOffer> bannersOffer = new ArrayList<BannerOffer>();
		BannerOfferService bannerOfferService = new BannerOfferService();
		bannersOffer = bannerOfferService.findAllByStore(id_store);
		return bannersOffer;
	}
}
