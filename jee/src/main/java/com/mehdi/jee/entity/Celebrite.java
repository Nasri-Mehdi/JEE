package com.mehdi.jee.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name="celebrite")
public class Celebrite implements Serializable {
	
	@Id
	private int num_Celebrite;
	
	@Column(length=16)
	private String nom;
	
	@Column(length=16)
	private String prenom;
	
	@Column(length=10)
	private String nationalite;
	
	@Column(length=6)
	private String epoque;
	
	
	@ManyToMany
	@JoinTable(name="associeA", joinColumns=@JoinColumn(name="num_Celebrite"), inverseJoinColumns= @JoinColumn(name="codeM"))
	private Collection<Monument> monuments;




	public Celebrite() {
		super();
	}




	public Celebrite(int num_Celebrite, String nom, String prenom, String nationalite, String epoque,
			Collection<Monument> monuments) {
		super();
		this.num_Celebrite = num_Celebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
		this.monuments = monuments;
	}




	public int getNum_Celebrite() {
		return num_Celebrite;
	}
	public void setNum_Celebrite(int num_Celebrite) {
		this.num_Celebrite = num_Celebrite;
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




	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}




	public String getEpoque() {
		return epoque;
	}
	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}




	public Collection<Monument> getMonuments() {
		return monuments;
	}
	public void setMonuments(Collection<Monument> monuments) {
		this.monuments = monuments;
	}



	
	
	
	

}
