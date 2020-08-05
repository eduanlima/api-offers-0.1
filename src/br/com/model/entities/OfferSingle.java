package br.com.model.entities;

import java.io.Serializable;

public class OfferSingle extends Offer implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
	private String image;
	
	public OfferSingle() {}
	
	public OfferSingle(String description, String image) {
		super();
		this.description = description;
		this.image = image;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}
}

