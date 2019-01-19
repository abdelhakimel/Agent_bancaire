package com.proj.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.gson.Gson;
import com.proj.model.Agent;
import com.proj.model.Client_identity;
import com.proj.model.Login;
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
	@ManagedProperty(value="#{loginBean}")
	  private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public  void MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL("http://localhost:8080/Agent/getAllClients");
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
		conection.setRequestProperty("authorization",login.getToken());
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
		System.out.println("ADD "+SessionUtils.getUserName());
		Agent ag=new Agent();
		ag.setUsername(SessionUtils.getUserName());
		cl.setAgent(ag);
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
		con.setRequestProperty("authorization",login.getToken());
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

	public Client_identity getClient(int id)
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getClient?id_client="+id);
	 
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization",login.getToken());
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
	public int desactivateCompte(Client_identity  cl)
	{
		System.out.println("method activate");
	Agent ag=new Agent();
	ag.setUsername( login.getUsername());
	cl.setAgent(ag);
	URL obj;
	int responseCode = 0;
	try {
		obj = new URL("http://localhost:8080/Agent/desactivateCompte");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("authorization",login.getToken());
				con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		Gson gson = new Gson();
		os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
		os.flush();
		os.close();
		System.out.println(gson.toJson(cl).toString());
		 responseCode = con.getResponseCode();
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
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return responseCode;
		
	}
	public int activateCompte(Client_identity cl) 

	{	System.out.println("method activate");
		Agent ag=new Agent();
		ag.setUsername(login.getUsername());
		cl.setAgent(ag);
		URL obj;
		int responseCode = 0;
		try {
			obj = new URL("http://localhost:8080/Agent/activateCompte");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("authorization",login.getToken());
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			Gson gson = new Gson();
			os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
			os.flush();
			os.close();
			System.out.println(gson.toJson(cl).toString());
			 responseCode = con.getResponseCode();
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
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseCode;
	}
	
	
public List<Client_identity> getAllClient()
	{
		System.out.println("GetAll function");
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getAllClients?username="+login.getUsername());
	      System.out.println("ClientDAo :" +login.getToken());
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization",login.getToken());
	      
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
	 
	 
	    
	      return list;
	}
	
	public List<Client_identity> getAllNotActivatedClients()
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getAllNotActivatedClients");
	      System.out.println("ClientDAo :" +login.getToken());
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON).header("authorization",login.getToken());
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
	
	public int deleteCompte(Client_identity cl)
	{
		URL obj;
		int responseCode = 0;
		try {
				obj = new URL("http://localhost:8080/Agent/deleteClient");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("authorization",login.getToken());
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			Gson gson = new Gson();
			os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
			os.flush();
			os.close();
			System.out.println(gson.toJson(cl).toString());
			 responseCode = con.getResponseCode();
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
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseCode;	
	}
	public int SwitchactivateCompte(Client_identity cl,boolean activate)
	{
		URL obj;
		int responseCode = 0;
		try {
				obj = new URL("http://localhost:8080/Agent/switchActivation");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("authorization",login.getToken());
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			Gson gson = new Gson();
			os.write(gson.toJson(cl).toString().getBytes("UTF-8"));
			os.flush();
			os.close();
			System.out.println(gson.toJson(cl).toString());
			 responseCode = con.getResponseCode();
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
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseCode;	}
}
