package com.proj.model;

import java.io.Serializable;
import java.util.List;





public class Agent extends UserMapping implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Agence agence;

	private Admin admin;
	
	private List<Client_identity> clients;
	

	private List<Reclamation> reclamations;

	private List<Compte> comptes;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agent(String nom, String prenom, String adresse, String telephone, String email, String username,
			String password, String cin, boolean activated, Agence agence, Admin admin , Role role) {
		super(nom, prenom, adresse, telephone, email, username, password, cin, activated , role);
		this.agence = agence;
		this.admin = admin;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Client_identity> getClients() {
		return clients;
	}

	public void setClients(List<Client_identity> clients) {
		this.clients = clients;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	

	

	
	
	
	
}
