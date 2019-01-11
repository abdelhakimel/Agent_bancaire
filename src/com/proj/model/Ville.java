package com.proj.model;

import java.io.Serializable;





import java.util.List;

public class Ville implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	
	private List<Agence> agences;
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(String nom) {
		super();
		this.nom = nom;
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
	public List<Agence> getAgences() {
		return agences;
	}
	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
	
	
	
}
