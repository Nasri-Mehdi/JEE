package com.mehdi.jee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String nom;
	private String prenom;
	private String role;
	private String MDP;
	
	
	public User() {
		super();
	}


	public User(String email, String nom, String prenom, String role, String mDP) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.MDP = mDP;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	public String getMDP() {
		return MDP;
	}
	
	public void setMDP(String mDP) {
		MDP = mDP;
	}
	
	
	
	
	

}
