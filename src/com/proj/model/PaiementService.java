package com.proj.model;

import java.io.Serializable;





public class PaiementService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * il faut ajouter encore plus d'attributs
	 */
	

	private int id;
	private Long numeroContrat;
	private Long numeroTelephone;
	private double montant;

	private SousCategorieService sousCategorieService;

	private Compte compte;
	
	public PaiementService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaiementService(Long numeroContrat, Long numeroTelephone, double montant,
			SousCategorieService sousCategorieService, Compte compte) {
		super();
		this.numeroContrat = numeroContrat;
		this.numeroTelephone = numeroTelephone;
		this.montant = montant;
		this.sousCategorieService = sousCategorieService;
		this.compte = compte;
	}

	public Long getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public Long getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(Long numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public SousCategorieService getSousCategorieService() {
		return sousCategorieService;
	}

	public void setSousCategorieService(SousCategorieService sousCategorieService) {
		this.sousCategorieService = sousCategorieService;
	}
	
	
}
