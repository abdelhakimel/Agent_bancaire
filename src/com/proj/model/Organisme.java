package com.proj.model;

import java.io.Serializable;
import java.util.List;



public class Organisme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private Long rib;

	private List<Don> dons;
	
	public Organisme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organisme(String nom, Long rib) {
		super();
		this.nom = nom;
		this.rib = rib;
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

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}
	
	
	
}
