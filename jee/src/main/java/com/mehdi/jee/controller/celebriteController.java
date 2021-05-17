package com.mehdi.jee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehdi.jee.Dao.ProImp;
import com.mehdi.jee.entity.Celebrite;
import com.mehdi.jee.entity.Departement;
import com.mehdi.jee.entity.Lieu;



@Controller
@RequestMapping(value="/celebrite")
public class celebriteController {
		
	@Autowired
	private ProImp proImp;
		
		
		
	@RequestMapping(value ="/listCel", method = RequestMethod.GET)
	public String listceleb(Model model) {
			
		List<Celebrite> lcelebs = proImp.findAllC();
		model.addAttribute("listcelebs", lcelebs);
		return "Celebrite";
	}
	
	
	
	@RequestMapping(value ="/listCelU", method = RequestMethod.GET)
	public String listcelebU(Model model) {
			
		List<Celebrite> lcelebs = proImp.findAllC();
		model.addAttribute("listcelebs", lcelebs);
		return "CelebriteU";
	}
	
	
	
	
	@RequestMapping(value="/ChargerCelebrite", method = RequestMethod.GET)
	public String ChargerCelebrite(Model model) {
		model.addAttribute("celebriteF", new Celebrite());
		return "chargCelebrite";
	}
	
	@PostMapping(value="/ajouteCel")
	public String ajoutCeleb (Model model, @ModelAttribute("celebriteF") Celebrite chCeleb) {
		proImp.save(chCeleb);
		List<Celebrite> lcelebs = proImp.findAllC();
		model.addAttribute("listcelebs", lcelebs);
		return "Celebrite";
	}
	
	
	//Modification
	@RequestMapping(value="/modification", params= {"num_Celebrite"})
	public String ModifiCeleb(@RequestParam(value="num_Celebrite") int num_Celebrite, Model model) {
	
		Celebrite editCeleb = proImp.getCelebrite(num_Celebrite);
		model.addAttribute("modificationCF", editCeleb);
		return "modifiCeleb";
		
	}
	
	@RequestMapping(value="/modifications", method = RequestMethod.POST) 
	public String editCeleb(@ModelAttribute("modificationC") Celebrite updateCeleb) {
		proImp.update(updateCeleb);
		return "redirect:/celebrite/listCel";
	}
	
	
	
	@RequestMapping (value="/Supprimer")
	public String suppcel(int num_Celebrite) {
		proImp.delete(num_Celebrite);
		return "redirect:listCel";
	}
		
	
}
