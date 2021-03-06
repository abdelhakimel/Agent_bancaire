package com.proj.Dao;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.proj.model.Login;



public class LoginDAO {

	

	public static String validate(String user, String password) throws IOException {
		URL obj = new URL("https://e-banking-project.herokuapp.com/login");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");

		// For POST only - START
		con.setDoOutput(true);
		Login log=new Login();
		log.setPassword(password);
		log.setUsername(user);
		OutputStream os = con.getOutputStream();
		Gson gson = new Gson();
		os.write(gson.toJson(log).toString().getBytes("UTF-8"));
		os.flush();
		os.close();
		
		// For POST only - END
		System.out.println(gson.toJson(log).toString());
		int responseCode = con.getResponseCode();
		String token=con.getHeaderField("Authorization");		
		System.out.println("POST Response Code :: " + responseCode);
		return token;
		
	
	}
}