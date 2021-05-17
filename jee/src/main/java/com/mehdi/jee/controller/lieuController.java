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
import com.mehdi.jee.entity.Departement;
import com.mehdi.jee.entity.Lieu;


@Controller
@RequestMapping(value="/Lieu")
public class lieuController {
	
	@Autowired
	private ProImp proImp;
	
	
	
	@RequestMapping(value="/listLieu", method=RequestMethod.GET)
	public String listLieu(Model model) {
		
		List<Lieu> lLieu =proImp.findAllL();
		model.addAttribute("listLieux", lLieu);
		return "listLieu";	
	}
	
	
	@RequestMapping(value="/listLieuU", method=RequestMethod.GET)
	public String listLieuU(Model model) {
		
		List<Lieu> lLieu =proImp.findAllL();
		model.addAttribute("listLieux", lLieu);
		return "listLieuU";	
	}
	
	
	
	@RequestMapping(value="/chargeLieu", method = RequestMethod.GET)
	public String ChargeLieu(Model model) {
		
		model.addAttribute("lieuF", new Lieu());
		return "chargLieu";
	}
	
	@PostMapping(value="/ajouteLieu")
	public String ajoutLieu(Model model, @ModelAttribute("lieuF") Lieu lu) {
		proImp.save(lu);
		
		List<Lieu> lLieu=proImp.findAllL();
		model.addAttribute("listLieux", lLieu);
		return "listLieu";
	}
	
	
	//Modification
	@RequestMapping(value="/modification", params= {"codeInsee"})
	public String ModifiLieu(@RequestParam(value="codeInsee") String codeInsee, Model model) {
	
		Lieu editlieu = proImp.getLieu(codeInsee);
		model.addAttribute("modificationLF", editlieu);
		return "modifiLieu";
		
	}
	
	@RequestMapping(value="/modifications", method = RequestMethod.POST) 
	public String editLieu(@ModelAttribute("modificationL") Lieu updateLieu) {

		proImp.update(updateLieu);
		return "redirect:/Lieu/listLieu";

	}
	
	
	
	@RequestMapping(value="/List", params= {"codeInsee"})
	public String infoDep(@RequestParam(value="codeInsee") String codeInsee, Model model) {
		
		Lieu listdep = proImp.getLieu(codeInsee);
		model.addAttribute("ListLF", listdep);
		return "listBylieu";
	}
	
	
	@RequestMapping(value="/ListU", params= {"codeInsee"})
	public String infoDepU(@RequestParam(value="codeInsee") String codeInsee, Model model) {
		
		Lieu listdep = proImp.getLieu(codeInsee);
		model.addAttribute("ListLF", listdep);
		return "listBylieuU";
	}
	
	
	
	
	
	@RequestMapping(value="/Supprimer")
	public String suppLieu(String codeInsee) {
		proImp.delete(codeInsee);
		return "redirect:listLieu";
	}
	

}
