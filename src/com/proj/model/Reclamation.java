package com.proj.model;

import java.io.Serializable;




public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String corps;
	private String etat;
	
	
	private Client_identity client;

	private Agent agent;
	
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reclamation(String corps, String etat, Client_identity client, Agent agent) {
		super();
		this.corps = corps;
		this.etat = etat;
		this.client = client;
		this.agent = agent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Client_identity getClient() {
		return client;
	}

	public void setClient(Client_identity client) {
		this.client = client;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
