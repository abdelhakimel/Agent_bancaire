package com.proj.model;



public abstract class UserMapping extends User{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserMapping(String nom, String prenom, String adresse, String telephone, String email, String username, String password, String cin, boolean activated,Role role) {
        super(nom, prenom, adresse, telephone, email, username, password, cin, activated,role);
    }

    public UserMapping() {}
}
