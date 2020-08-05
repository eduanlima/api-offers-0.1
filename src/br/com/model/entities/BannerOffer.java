package br.com.model.entities;

import java.io.Serializable;
import java.util.Date;

public class BannerOffer implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Store store;
	private String title;
	private Date dateInitial;
	private Date dateLimit;
	private String image;
	private Boolean status;
	
	public BannerOffer() {}
	
	public BannerOffer(Integer id, Store store, Sector sector, Date dateInitial, Date dateLimit, String title, Boolean status) {
		this.id = id;
		this.store = store;
		this.title = title;
		this.dateInitial = dateInitial;
		this.dateLimit = dateLimit;
		this.image = image;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateInitial() {
		return dateInitial;
	}

	public void setDateInitial(Date dateInitial) {
		this.dateInitial = dateInitial;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BannerOffer other = (BannerOffer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
