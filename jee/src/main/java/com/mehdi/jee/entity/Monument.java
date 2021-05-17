package com.mehdi.jee.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="Monument")
public class Monument implements Serializable {
	
	@Id
	@Column(length=5)
	private String codeM;
	
	@Column(length=25)
	private String nomM;
	
	@Column(length=10)
	private String proprietaire;
	
	@Column(length=16)
	private String typeMonument;
	
	private float longitude;
	private float latitude;
	
	@ManyToOne
	@JoinColumn(name="codeLieu", referencedColumnName="codeInsee")
	private Lieu codeLieu;
	
	
	@ManyToMany
	@JoinTable(name="associeA", joinColumns=@JoinColumn(name="codeM"), inverseJoinColumns = @JoinColumn(name="num_Celebrite"))
	private Collection<Celebrite> celebrites;


	public Monument() {
		super();
	}


	public Monument(String codeM, String nomM, String proprietaire, String typeMonument, float longitude,
			float latitude, Lieu codeLieu, Collection<Celebrite> celebrites) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.proprietaire = proprietaire;
		this.typeMonument = typeMonument;
		this.longitude = longitude;
		this.latitude = latitude;
		this.codeLieu = codeLieu;
		this.celebrites = celebrites;
	}


	public String getCodeM() {
		return codeM;
	}
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}


	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}


	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}


	public String getTypeMonument() {
		return typeMonument;
	}
	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
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


	public Lieu getCodeLieu() {
		return codeLieu;
	}
	public void setCodeLieu(Lieu codeLieu) {
		this.codeLieu = codeLieu;
	}


	public Collection<Celebrite> getCelebrites() {
		return celebrites;
	}
	public void setCelebrites(Collection<Celebrite> celebrites) {
		this.celebrites = celebrites;
	}


	
	
	
}
