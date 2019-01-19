package com.proj.model;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.proj.Dao.LoginDAO;

import util.SessionUtils;


@ManagedBean(name="loginBean")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String username;
	private String password;
	private String msg;
	private String token;

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//validate login
	public String validateUsernamePassword() {
		String valid = null ;
		try {
			valid = LoginDAO.validate(username, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (valid!=null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			session.setAttribute("token", valid);
			System.out.println("Validate user :"+valid);
			System.out.println("Session get :"+SessionUtils.getUserName());
			this.token=valid;
			return "agent";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
	}


}
