package com.proj.model;

import java.io.Serializable;


public class Don implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private int id;
	private double montant;

	private Organisme organisme;

	private Client_identity client;
	
	public Don() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Don(double montant, Organisme organisme, Client_identity client) {
		super();
		this.montant = montant;
		this.organisme = organisme;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Organisme getOrganisme() {
		return organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	public Client_identity getClient() {
		return client;
	}

	public void setClient(Client_identity client) {
		this.client = client;
	}
	

}
