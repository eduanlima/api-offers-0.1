package br.com.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/adresses")
public class ServicesAddressAPI{
	
	@GET
	@Path("/all")
	@Produces(MediaType.TEXT_PLAIN)
	public String findAll(){
		return "it's only a test";
	}
		
	/*
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Address> findAll(){
		AddressService serviceAddress = new AddressService();
		List<Address> adresses = new ArrayList<Address>();
		adresses = serviceAddress.findAll();
		return adresses;
	}
	*/
}
