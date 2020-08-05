package br.com.model.entities;

import java.io.Serializable;

public class OfferBanner extends Offer implements Serializable{

	private static final long serialVersionUID = 1L;
	private BannerOffer bannerOffer;
	
	public OfferBanner() {};
	
	public OfferBanner(BannerOffer bannerOffer) {
		super();
		this.bannerOffer = bannerOffer;
	}

	public BannerOffer getBannerOffer() {
		return bannerOffer;
	}

	public void setBannerOffer(BannerOffer bannerOffer) {
		this.bannerOffer = bannerOffer;
	}
	
}

