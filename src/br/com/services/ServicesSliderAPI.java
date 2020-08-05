package br.com.services;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.entities.BannerSlider;
import br.com.model.services.BannerSliderService;

@Path("/slider")
public class ServicesSliderAPI {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/{id_store}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<BannerSlider> findAll(@PathParam("id_store") Integer id_store){
		List<BannerSlider> bannersSlider = new ArrayList<BannerSlider>();
		BannerSliderService bannerSliderService = new BannerSliderService();
		bannersSlider = bannerSliderService.findAllByStore(id_store);
		return bannersSlider;
	}
}
