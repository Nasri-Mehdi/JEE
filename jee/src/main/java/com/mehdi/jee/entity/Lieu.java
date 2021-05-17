package com.mehdi.jee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Lieu")
public class Lieu implements Serializable {
	
	@Id
	@Column(length=5)
	private String codeInsee;
	
	@Column(length=46)
	private String nomCom;
	
	private float longitude;
	private float latitude;
	
	@ManyToOne
	@JoinColumn(name ="dep", referencedColumnName="dep")
	private Departement dep;
	
	
	@OneToMany (mappedBy="codeLieu", fetch=FetchType.LAZY)
	private List<Monument> monument;


	public Lieu() {
		super();
	}


	public Lieu(String codeInsee, String nomCom, float longitude, float latitude, Departement dep,
			List<Monument> monument) {
		super();
		this.codeInsee = codeInsee;
		this.nomCom = nomCom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dep = dep;
		this.monument = monument;
	}


	public String getCodeInsee() {
		return codeInsee;
	}


	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}


	public String getNomCom() {
		return nomCom;
	}


	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public Departement getDep() {
		return dep;
	}


	public void setDep(Departement dep) {
		this.dep = dep;
	}


	public List<Monument> getMonument() {
		return monument;
	}


	public void setMonument(List<Monument> monument) {
		this.monument = monument;
	}


	
	
	
	
	

}
