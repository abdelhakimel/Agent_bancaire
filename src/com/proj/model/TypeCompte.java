package com.proj.model;

import java.io.Serializable;
import java.util.List;





public class TypeCompte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;

	private List<Compte> comptes;
	
	public TypeCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeCompte(String description) {
		super();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
