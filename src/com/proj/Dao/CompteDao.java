package com.proj.Dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.proj.model.Client_identity;
import com.proj.model.Compte;
import com.proj.model.Login;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import util.SessionUtils;
@ManagedBean
public class CompteDao {


	public List<Compte> getCompteByIdClient(int id)
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("https://e-banking-project.herokuapp.com/Agent/getComptesByClient?id="+id);
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization",SessionUtils.getToken());
	      ClientResponse response = builder.get(ClientResponse.class);
	 
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	          return null;
	      }
	      GenericType<List<Compte>> generic = new GenericType<List<Compte>>() {
	          // No thing
	      };
	 
	      List<Compte> list = response.getEntity(generic);
	 
	      System.out.println("Output from Server .... \n");
	 
	      for (Compte emp : list) {
	          System.out.println(" --- ");
	          System.out.println("Emp No .... " + emp.getRib());
	         
	      }
	      return list;
	}
	public int deposer(long rib,double solde)
	{
		System.out.println("Rib");
		System.out.println("GetDEposer function");
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("https://e-banking-project.herokuapp.com/Agent/Deposer?rib="+rib+"&solde="+solde);
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization",SessionUtils.getToken());
	      
	      ClientResponse response = builder.get(ClientResponse.class);
	 
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	          return 0;
	      }
	      
	    
	      return response.getStatus();
	}
}
