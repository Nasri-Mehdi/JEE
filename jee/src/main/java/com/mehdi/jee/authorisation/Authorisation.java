package com.mehdi.jee.authorisation;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.mehdi.jee.entity.User;

public class Authorisation {
	
	private ArrayList<String> authorized = new ArrayList<String>();
	
	
	public Authorisation() {
		
		authorized.add("utilisateurs");
		
		authorized.add("editDepartement");
		authorized.add("supprimerDepartement");
		
		authorized.add("manageDepartement/remove");
		//authorized.add("manageCelebrite/remove");
		
	}
	
	public boolean checkAccess(String route, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if(user == null) return false;
		if(user.getRole().equals("Admin")) {
			if (authorized.contains(route)) {
				return false;
			}
		}
		
		return true;
	}

}
