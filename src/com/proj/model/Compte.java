package com.proj.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;





public class Compte implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long rib;
	
	private Date dateCreation;

	private TypeCompte type;
	
	private double sold;

	private Client_identity client;

	private Agent agent;
	

	private List<Virement> virementsEnvoyes;
	
	private List<Virement> virementsRecus;
	

	private List<PaiementService> paiementServices;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(Long rib, Date dateCreation, TypeCompte type, double sold, Client_identity client, Agent agent) {
		super();
		this.rib = rib;
		this.dateCreation = dateCreation;
		this.type = type;
		this.sold = sold;
		this.client = client;
		this.agent = agent;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public TypeCompte getType() {
		return type;
	}

	public void setType(TypeCompte type) {
		this.type = type;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
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

	public List<Virement> getVirementsEnvoyes() {
		return virementsEnvoyes;
	}

	public void setVirementsEnvoyes(List<Virement> virementsEnvoyes) {
		this.virementsEnvoyes = virementsEnvoyes;
	}

	public List<Virement> getVirementsRecus() {
		return virementsRecus;
	}

	public void setVirementsRecus(List<Virement> virementsRecus) {
		this.virementsRecus = virementsRecus;
	}

	public List<PaiementService> getPaiementServices() {
		return paiementServices;
	}

	public void setPaiementServices(List<PaiementService> paiementServices) {
		this.paiementServices = paiementServices;
	}
	
	
	
}
