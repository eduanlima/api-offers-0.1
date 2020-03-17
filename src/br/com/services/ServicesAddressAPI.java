package br.com.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.model.entities.Address;
import br.com.model.services.AddressService;

@Path("/adresses")
public class ServicesAddressAPI{
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Address> findAll(){
		AddressService serviceAddress = new AddressService();
		List<Address> adresses = new ArrayList<Address>();
		adresses = serviceAddress.findAll();
		return adresses;
	}
}
