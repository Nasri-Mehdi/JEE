package com.mehdi.jee.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer dep;
	
	@Column(length=46)
	private String chef_lieu;
	
	@Column(length=30)
	private String nom_dep;
	
	@Column(length=4)
	private String reg;
	
	@OneToMany(mappedBy="dep", fetch=FetchType.LAZY)
	private List<Lieu> lieu; 

	
	
	
	public Departement() {
		super();
	}




	public Departement(Integer dep, String chef_lieu, String nom_dep, String reg, List<Lieu> lieu) {
		super();
		this.dep = dep;
		this.chef_lieu = chef_lieu;
		this.nom_dep = nom_dep;
		this.reg = reg;
		this.lieu = lieu;
	}




	public Integer getDep() {
		return dep;
	}




	public void setDep(Integer dep) {
		this.dep = dep;
	}




	public String getChef_lieu() {
		return chef_lieu;
	}




	public void setChef_lieu(String chef_lieu) {
		this.chef_lieu = chef_lieu;
	}




	public String getNom_dep() {
		return nom_dep;
	}




	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}




	public String getReg() {
		return reg;
	}




	public void setReg(String reg) {
		this.reg = reg;
	}




	public List<Lieu> getLieu() {
		return lieu;
	}




	public void setLieu(List<Lieu> lieu) {
		this.lieu = lieu;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
