package com.mehdi.jee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mehdi.jee.Dao.ProImp;
import com.mehdi.jee.authorisation.Authorisation;
import com.mehdi.jee.entity.Monument;
import com.mehdi.jee.entity.User;

@Controller
public class userController {
	
	@Autowired
	private ProImp proImp;
	
	private Authorisation authorisation = new Authorisation();
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String accueilDefault() {
		
		return "accueil";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("UF", user);
		return "Login";
		
	}
	
	
	
	@RequestMapping(value="/inscription", method = RequestMethod.GET)
	public String inscriotion(Model model) {
		model.addAttribute("USER", new User());
		return "Inscription";
	}
	
	@PostMapping(value="/tlogin")
	public String ajoutUser (Model model , @ModelAttribute("USER") User newUser) {
		proImp.save(newUser);
		return "redirect:/login";
		
	}
	
	
	
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public String checkLogin(Model model, @ModelAttribute("USER") User userR, HttpSession session) {
		boolean error = false;
		User user = proImp.getUser(userR);
		if (user != null) {
			session.setAttribute("USER", user);
			return "index";
		}
		error = true;
		model.addAttribute("error", error);
		
		return "redirect:/login";
	}
	
	
	

}
