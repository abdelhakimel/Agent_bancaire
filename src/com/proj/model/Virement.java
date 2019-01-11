package com.proj.model;

import java.io.Serializable;
import java.util.Date;





public class Virement implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	private int id;
	
	
	private Compte compteSource;

	private Compte compteDestination;
	
	private double montant;

	private Date dateVirement;
	
	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virement(Compte compteSource, Compte compteDestination, double montant, Date dateVirement) {
		super();
		this.compteSource = compteSource;
		this.compteDestination = compteDestination;
		this.montant = montant;
		this.dateVirement = dateVirement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getCompteSource() {
		return compteSource;
	}

	public void setCompteSource(Compte compteSource) {
		this.compteSource = compteSource;
	}

	public Compte getCompteDestination() {
		return compteDestination;
	}

	public void setCompteDestination(Compte compteDestination) {
		this.compteDestination = compteDestination;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	@Override
	public String toString() {
		return "Virement [compteSource=" + compteSource + ", compteDestination=" + compteDestination + ", montant="
				+ montant + ", dateVirement=" + dateVirement + "]";
	}
	
	
}
