package br.com.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Offer implements Serializable, Comparable<Offer>{

	private static final long serialVersionUID = 1L;
	protected Store store;
	protected Product product;
	protected String description;
	protected Double price;
	protected Date dateInitial;
	protected Date dateLimit;
	protected String imageMin;
	protected Boolean mapped;
	protected Boolean status;
	
	public Offer() {}

	public Offer(Store store, Product product, String description, Double price, Date dateInitial, Date dateLimit, String imageMin,
			Boolean mapped, Boolean status) {
		super();
		this.store = store;
		this.product = product;
		this.description = description;
		this.price = price;
		this.dateInitial = dateInitial;
		this.dateLimit = dateLimit;
		this.imageMin = imageMin;
		this.mapped = mapped;
		this.status = status;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getImageMin() {
		return imageMin;
	}

	public void setImageMin(String imageMin) {
		this.imageMin = imageMin;
	}
	
	public Boolean getMapped() {
		return mapped;
	}

	public void setMapped(Boolean mapped) {
		this.mapped = mapped;
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
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Offer other = (Offer) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(Offer o) {
		return price.compareTo(o.getPrice());
	}
	
}
