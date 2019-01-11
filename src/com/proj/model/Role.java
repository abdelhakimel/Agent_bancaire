/**
 * 
 */
package com.proj.model;

import java.io.Serializable;





public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String role;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
