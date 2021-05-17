package com.mehdi.jee.Dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mehdi.jee.entity.Celebrite;
import com.mehdi.jee.entity.Departement;
import com.mehdi.jee.entity.Lieu;
import com.mehdi.jee.entity.Monument;
import com.mehdi.jee.entity.User;


@Transactional
@Repository
public class ProImp implements IprojetDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	
	
	@Override
	public List<Departement> findAll() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select p from Departement p");
		return req.getResultList();
	}
	
	@Override
	public List<Departement> findByNomdep(String nom_dep) {
		// TODO Auto-generated method stub
		Query req2 = entityManager.createQuery("select p from Departement p where nom_dep= :x");
		return req2.getResultList();
	}

	@Override
	public Departement save(Departement d) {
		// TODO Auto-generated method stub
		entityManager.persist(d);
		return d;
	}

	@Override
	public Departement update(Departement d) {
		// TODO Auto-generated method stub
		entityManager.merge(d);
		return d;
	}

	@Override
	public void delete(Integer dep) {
		// TODO Auto-generated method stub
		Departement suppdep = entityManager.find(Departement.class, dep);
		if(suppdep != null) {
			entityManager.remove(suppdep);
		}
	}
	
	@Override
	public Departement getDepartement(Integer dep) {
		// TODO Auto-generated method stub
		Departement dept=entityManager.find(Departement.class, dep);
		return dept;
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Departement getlieuByDepartement(List<Lieu> lieu) {
		// TODO Auto-generated method stub
		Departement llieu = entityManager.find(Departement.class, lieu);
		return llieu;
	}
	
	
	
	@Override
	public List<Lieu> getBydep(Integer dep) {
		// TODO Auto-generated method stub
		Query reqbydep = entityManager.createQuery("select p from Lieu l, departement d where d.dep=l.dep and d.dep=:x");
		reqbydep.setParameter("x", dep);
		
		return reqbydep.getResultList();
	}
	
	
	
	@Override
	public List<Lieu> getLieubydep(Integer dep) {
		// TODO Auto-generated method stub
		Query reqbydep = entityManager.createQuery("select p from Lieu l where l.dep=:x");
		reqbydep.setParameter("x", dep);
		
		return reqbydep.getResultList();
	}
	
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	@Override
	public User getUser(User userR) {
		// TODO Auto-generated method stub
		User LogUser = new User();
		LogUser = entityManager.find(User.class, userR.getEmail());
		if (LogUser == null) {
			System.out.println("Utilisateur n'exist pas");
			//JOptionPane.showMessageDialog(null,"Utilisateur n'exist pas");
			
			return null;
		}
		
		if (!userR.getMDP().equals(LogUser.getMDP())) {
			return null;
		}
		else return LogUser;
	}
	

	@Override
	public User save(User newUser) {
		// TODO Auto-generated method stub
		User newU = new User();
		newU = entityManager.find(User.class, newUser.getEmail());
		if(newU != null) {
			throw new RuntimeException("Deja ce mail utiliser");
		}
		else {
			entityManager.persist(newUser);
			return newUser;
		}
	}
	
	
	
	
	
	
	
//Celebrite
	
	@Override
	public List<Celebrite> findAllC() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select p from Celebrite p");
		return req.getResultList();
	}

	@Override
	public Celebrite save(Celebrite c) {
		// TODO Auto-generated method stub
		entityManager.persist(c);
		return c;
	}

	@Override
	public Celebrite update(Celebrite c) {
		// TODO Auto-generated method stub
		entityManager.merge(c);
		return c;
	}

	@Override
	public void delete(int num_Celebrite) {
		// TODO Auto-generated method stub
		Celebrite suppcel = entityManager.find(Celebrite.class, num_Celebrite);
		if(suppcel != null) {
			entityManager.remove(suppcel);
		}
	}
	
	
	@Override
	public Celebrite getCelebrite(int num_Celebrite) {
		// TODO Auto-generated method stub
		Celebrite celeb = entityManager.find(Celebrite.class, num_Celebrite);
		return celeb;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

//Lieu
	@Override
	public List<Lieu> findAllL() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select l from Lieu l");
		return req.getResultList();
	}

	
	
/*	@Override
	public Lieu save(Lieu l) {
		// TODO Auto-generated method stub
		Lieu lieudep = new Lieu();
		lieudep = entityManager.find(Lieu.class, l.getDep());
		if(lieudep != null) {
			entityManager.persist(l);
			return l;
		}else {
			throw new RuntimeException("ce departement n'exist pas");
		}
		
	}*/
	
/////////////////////////////////////////////////////////
	@Override
	public Lieu save(Lieu l) {
		// TODO Auto-generated method stub
		entityManager.persist(l);
		return l;
	}
/////////////////////////////////////////////////////////

	@Override
	public Lieu update(Lieu l) {
		// TODO Auto-generated method stub
		entityManager.merge(l);
		return l;
	}

	@Override
	public void delete(String codeInsee) {
		// TODO Auto-generated method stub
		Lieu supplieu = entityManager.find(Lieu.class, codeInsee);
		if(supplieu != null) {
			entityManager.remove(supplieu);
		}
	}
	
	
	@Override
	public Lieu getLieu(String codeInsee) {
		// TODO Auto-generated method stub
		Lieu lieu = entityManager.find(Lieu.class, codeInsee);
		return lieu;
	}


	
	
	

//Monument
	@Override
	public List<Monument> findAllM() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("select m from Monument m");
		return req.getResultList();
	}

	@Override
	public Monument save(Monument m) {
		// TODO Auto-generated method stub
		entityManager.persist(m);
		return m;
	}

	@Override
	public Monument update(Monument m) {
		// TODO Auto-generated method stub
		entityManager.merge(m);
		return m;
	}
	
	
	@Override
	public void deleteM(String codeM) {
		// TODO Auto-generated method stub
		Monument suppMonument = entityManager.find(Monument.class, codeM);
		if(suppMonument != null) {
			entityManager.remove(suppMonument);	
		}
	}
	
	
	@Override
	public Monument getMonument(String codeM) {
		// TODO Auto-generated method stub
		Monument monu = entityManager.find(Monument.class, codeM);
		return monu;
	}
	
	
	@Override
	public double getDistanceBetweenMonument(String nomMA) {
		// TODO Auto-generated method stub
		double distance = 0;
		double a = 111.16;
		String[] part = nomMA.split(",");
		
		Monument m1 = entityManager.find(Monument.class, part[0]);
		Monument m2 = entityManager.find(Monument.class, part[1]);
		
		double dlong = m1.getLongitude()-m2.getLongitude();
		double dlat = m1.getLatitude()-m2.getLatitude();
		
		distance = Math.sqrt((dlong*dlong)+(dlat*dlat))*a;
		
		return distance;
	}

	

	

	
	
	

}
