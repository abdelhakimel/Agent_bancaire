package com.proj.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.proj.Dao.CompteDao;

@ManagedBean(name="ClientCompte")
@SessionScoped
public class EditClientBean  {
	private Client_identity client;

	List<Compte> comptes;
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	private String Num;
	private long numcompte;
	private double solde;
	public Client_identity getClient() {
		return client;
	}

	public void setClient(Client_identity client) {
		this.client = client;
	}
	public String choix(Client_identity client)
	{
		System.out.println("Id :"+client.getId());
		this.client=client;
		this.comptes=new CompteDao().getCompteByIdClient(client.getId());
		numcompte=comptes.get(0).getRib();
		
		for (Compte compte : comptes) {
			System.out.println(" from function ************ "+compte.getRib());

		}
		return "depot";
	}
	public String deposer()
	{
		System.out.println("it is called");
		
		CompteDao dao=	new CompteDao();
		dao.deposer(numcompte, solde);
		return "comptes";
	}

	public long getNumcompte() {
		return numcompte;
	}

	public void setNumcompte(long numcompte) {
		this.numcompte = numcompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getNum() {
		return Num;
	}

	public void setNum(String num) {
		Num = num;
	}
	

}
