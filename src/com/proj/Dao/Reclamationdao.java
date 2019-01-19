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
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.gson.Gson;
import com.proj.model.Agent;
import com.proj.model.Login;
import com.proj.model.Reclamation;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@ManagedBean(name="ReclamationDAO")
public class Reclamationdao {
	@ManagedProperty(value="#{loginBean}")
	  private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public List<Reclamation> getAllReclamations()
	{
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		 
	      // Create Client based on Config
	 
	      WebResource webResource = client.resource("http://localhost:8080/Agent/getReclamations");
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
	      GenericType<List<Reclamation>> generic = new GenericType<List<Reclamation>>() {
	          // No thing
	      };
	 
	      List<Reclamation> list = response.getEntity(generic);
	    
	 
	    
	      return list;
	}
	public int verify(Reclamation rec)
	{
		Agent ag=new Agent();
		ag.setUsername( login.getUsername());
		rec.setAgent(ag);
		URL obj;
		int responseCode = 0;
		try {
			obj = new URL("http://localhost:8080/Agent/verifyRec");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("authorization",login.getToken());
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			Gson gson = new Gson();
			os.write(gson.toJson(rec).toString().getBytes("UTF-8"));
			os.flush();
			os.close();
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
}
