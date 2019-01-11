package com.proj.model;

import java.io.Serializable;
import java.util.List;





public class Admin extends UserMapping implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List<Agence> agences;
	

	private List<Agent> agents;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String nom, String prenom, String adresse, String telephone, String email, String username, String password, String cin, boolean activated,
			List<Agence> agences, List<Agent> agents , Role role) 
	{
        super(nom, prenom, adresse, telephone, email, username, password, cin, activated,role);
		this.agences = agences;
		this.agents = agents;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	

	

	
}
