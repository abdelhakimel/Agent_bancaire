package com.proj.model;



import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.proj.Dao.ClientDao;





@ManagedBean(name="client_bean")
@RequestScoped
public class Client_identity extends UserMapping implements Serializable{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private int codePostal;

	private Agent agent;
	
	private List<Don> dons;

	private List<Reclamation> reclamations;
	

	private List<Compte> comptes;
	
	public Client_identity() {
		super();
		// TODO Auto-generated constructor stub
		agent =new Agent();
		dons=new ArrayList<Don>();
		reclamations=new ArrayList<Reclamation>();
		comptes=new ArrayList<Compte>();


	}
	    private String confirmedPassword;
		private double limite;


	public Client_identity(String nom, String prenom, String adresse, String telephone, String email, String username,
			String password, String cin, boolean activated, int codePostal, Agent agent , Role role) {
		super(nom, prenom, adresse, telephone, email, username, password, cin, activated,role);
		this.codePostal = codePostal;
		this.agent = agent;
		
	}
	public void remp()
	{
		agent =new Agent();
		dons=new ArrayList<Don>();
		reclamations=new ArrayList<Reclamation>();
		comptes=new ArrayList<Compte>();

		agent.setNom("cc");
		dons.add(new Don());
		reclamations.add(new Reclamation());
		comptes.add(new Compte());
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
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
	
	
	public String save()
	{
		try {
			ClientDao clDao=new ClientDao();
			
			clDao.addClient(this);
			return "index";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return null;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}

	
	
	
	

}
