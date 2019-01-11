package com.proj.model;

import java.io.Serializable;
import java.util.List;





public class SousCategorieService implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;

	private CategorieService categorie;
	
	private List<PaiementService> paiementServices;
	
	public SousCategorieService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SousCategorieService(String description, CategorieService categorie) {
		super();
		this.description = description;
		this.categorie = categorie;
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

	public CategorieService getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieService categorie) {
		this.categorie = categorie;
	}

	public List<PaiementService> getPaiementServices() {
		return paiementServices;
	}

	public void setPaiementServices(List<PaiementService> paiementServices) {
		this.paiementServices = paiementServices;
	}
	
	
}
