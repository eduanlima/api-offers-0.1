package br.com.model.entities;

import java.io.Serializable;

public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String detail;
	private String icon;
	private Store store;
	private TypeContact typeContact;
	
	public Contact() {}
	
	public Contact(String detail, String icon, Store store, TypeContact typeContact) {
		super();
		this.detail = detail;
		this.icon = icon;
		this.store = store;
		this.typeContact = typeContact;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public TypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(TypeContact typeContact) {
		this.typeContact = typeContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
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
		Contact other = (Contact) obj;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		return true;
	}
	
}
