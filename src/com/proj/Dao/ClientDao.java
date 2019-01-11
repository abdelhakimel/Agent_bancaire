package com.proj.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.gson.Gson;
import com.proj.model.Client_identity;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import util.SessionUtils;
@ManagedBean(name="clienDao")
@SessionScoped
public class ClientDao {
	public static void MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL("http://localhost:8080/Agent/getAllClients");
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
		conection.setRequestProperty("authorization",SessionUtils.getToken());
				int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	    	  BufferedReader in = new BufferedReader(
	    	             new InputStreamReader(conection.getInputStream()));
	    	     String inputLine;
	    	     StringBuffer response = new StringBuffer();
	    	     while ((inputLine = in.readLine()) != null) {
	    	     	response.append(inputLine);
	    	     }
	    	     in.close();
	    	     //print in String
	    	     System.out.println(response.toString());
	    	     //Read JSON response and print
	    	     String s=response.toString();
	    	     s=s.replace("[", "");
	    	     s=s.replace("]", "");
//	    	     JSONObject myResponse = new JSONObject(s);
//	    	     System.out.println(s);
//	    	     System.out.println("statusCode- "+myResponse.getString("statusCode"));

	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	    
	}
	public void addClient(Client_identity cl) throws Exception {

		URL obj = new URL("http://localhost:8080/Agent/addClient");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("authorization",SessionUtils.getToken());
				con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		Gson gson = new Gson();
		os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
		os.flush();
		os.close();
		// For POST only - END
		System.out.println(gson.toJson(cl).toString());
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code from add :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	
		}
	public void editClient(Client_identity cl) throws Exception {

		URL obj = new URL("http://localhost:8080/Agent/editClient");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("authorization",SessionUtils.getToken());
				con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		Gson gson = new Gson();
		os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
		os.flush();
		os.close();
		// For POST only - END
		System.out.println(gson.toJson(cl).toString());
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code from edit :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	
		}

	
	public Client_identity getClient()
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getClient?id_client=5");
	 
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
	 
	 
	      Client_identity cl = (Client_identity) response.getEntity(Client_identity.class);
	 
	      System.out.println("Emp No .... " + cl.getNom());
	      System.out.println("Emp Name .... " + cl.getAdresse());
	      
	      return cl;
		
	}
	public Client_identity desactivateCompte(int id)
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/desactivateCompte?id_client="+id);
	 
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
	 
	      System.out.println("Output from Server .... \n");
	 
	      Client_identity cl = (Client_identity) response.getEntity(Client_identity.class);
	 
	      System.out.println("Emp No .... " + cl.getNom());
	      System.out.println("Emp Name .... " + cl.getAdresse());
	      
	      return cl;
		
	}
	public Client_identity activateCompte(int id)
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/activateCompte?id_client="+id);
	 
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
	 
	      System.out.println("Output from Server .... \n");
	 
	      Client_identity cl = (Client_identity) response.getEntity(Client_identity.class);
	 
	      System.out.println("Emp No .... " + cl.getNom());
	      System.out.println("Emp Name .... " + cl.getAdresse());
	      
	      return cl;
		
	}

	public List<Client_identity> getAllClient()
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getAllClients");
	      System.out.println("ClientDAo :" +SessionUtils.getToken());
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZ2VudDEiLCJleHAiOjE1NDgwNzA4MjQsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FHRU5UIn1dfQ.M2cJZ-He5-o3Ct72Ek4cFNptlazSg9aAR-3XNpihd5ZdXydjloROvD8qr33Cx_AgaX8snarOJIh6lWcmhsXfvw");
	 
	      ClientResponse response = builder.get(ClientResponse.class);
	 
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	          return null;
	      }
	      GenericType<List<Client_identity>> generic = new GenericType<List<Client_identity>>() {
	          // No thing
	      };
	 
	      List<Client_identity> list = response.getEntity(generic);
	 
	      System.out.println("Output from Server .... \n");
	 
	      for (Client_identity emp : list) {
	          System.out.println(" --- ");
	          System.out.println("Emp No .... " + emp.getId());
	          System.out.println("Emp Name .... " + emp.getNom());
	      }
	      return list;
	}
	
	
}
