package com.proj.model;

import java.io.Serializable;




public class Agence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String adresse;
	

	private Ville ville;
	

	private Admin admin;
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(String nom, String adresse, Ville ville, Admin admin) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
