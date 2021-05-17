package com.mehdi.jee.Dao;
import java.util.Collection;
import java.util.List;

import com.mehdi.jee.entity.Celebrite;
import com.mehdi.jee.entity.Departement;
import com.mehdi.jee.entity.Lieu;
import com.mehdi.jee.entity.Monument;
import com.mehdi.jee.entity.User;


public interface IprojetDao{
	
	//Departement
	public List<Departement> findAll();
	public List<Departement> findByNomdep(String nom_dep);
	public Departement save (Departement d);
	public Departement update(Departement d);
	public void delete(Integer dep);
	public Departement getDepartement (Integer dep);
	
	public Departement getlieuByDepartement (List<Lieu> lieu);
	
	public List<Lieu> getBydep (Integer dep);
	
	//Celebrite
	public List<Celebrite> findAllC();
	public Celebrite save (Celebrite c);
	public Celebrite update(Celebrite c);
	public void delete(int num_Celebrite);
	public Celebrite getCelebrite (int num_Celebrite);
	
	//Lieu
	public List<Lieu> findAllL();
	public Lieu save (Lieu l);
	public Lieu update (Lieu l);
	public void delete(String codeInsee);
	public Lieu getLieu (String codeInsee);
	public List<Lieu> getLieubydep (Integer dep);
	
	
	//Monument
	public List<Monument> findAllM();
	public Monument save (Monument m);
	public Monument update (Monument m);
	public void deleteM(String codeM);
	
	//public double getDistanceBetweenMonument(String monA, String monB);
	public double getDistanceBetweenMonument(String monA);
	//public List<Monument> getMonumentByLieu (String nomCom);
	public Monument getMonument (String codeM);

	//User
	public User getUser(User userR);
	public User save(User newUser);
}
