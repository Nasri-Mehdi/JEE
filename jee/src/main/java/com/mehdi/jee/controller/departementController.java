package com.mehdi.jee.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value="/departement")
public class departementController {
	
	@Autowired
	private ProImp proImp;
	
	
	/*@RequestMapping(value="", method = RequestMethod.GET)
	public String indexDefault() {
		return "index";
	}*/
	
	@RequestMapping(value ="/listDep", method = RequestMethod.GET)
	public String lisdept(Model model) {
		
		List<Departement> ldepts = proImp.findAll();
		model.addAttribute("listDepts", ldepts);
		return "listDep";
	}
	
	
	@RequestMapping(value ="/listDepU", method = RequestMethod.GET)
	public String lisdeptU(Model model) {
		
		List<Departement> ldepts = proImp.findAll();
		model.addAttribute("listDepts", ldepts);
		return "listDepU";
	}
	
	
	@RequestMapping(value="/ChargerDepartement", method = RequestMethod.GET)
	public String ChargerDdepartement(Model model) {
		model.addAttribute("departementF", new Departement());
		return "chargDep";
	}
	
	
	@PostMapping(value="/ajouteDep")
	public String ajoutDep (Model model, @ModelAttribute("departementF") Departement chDep) {
		proImp.save(chDep);
		List<Departement> ldepts = proImp.findAll();
		model.addAttribute("listDepts", ldepts);
		return "listDep";
	}
	
	
	
	//method supprime pour Departement
	@RequestMapping (value="/Supprimer")
	public String suppDep(Integer dep) {
		proImp.delete(dep);
		return "redirect:listDep";
	}
	
	
	//modification
	@RequestMapping(value="/modification", params= {"dep"})
	public String ModifiDep(@RequestParam(value="dep") Integer dep, Model model) {
	
		Departement editdep = proImp.getDepartement(dep);
		model.addAttribute("modificationDF", editdep);
		return "modifiDEP";
		
	}
	
	@RequestMapping(value="/modifications", method = RequestMethod.POST) 
	public String editDepartement(@ModelAttribute("modificationD") Departement updateDep) {

		proImp.update(updateDep);
		return "redirect:/departement/listDep";

	}
	
	
	
	//Affichage list lieu par dep
	@RequestMapping(value="/listLieuBydep", params= {"dep"})
	public String infoLieu (@RequestParam(value="dep") Integer dep, Model model) {
		
		List<Lieu> lieu = proImp.getLieubydep(dep);
		model.addAttribute("Listl", lieu);
		return "listBydep";
		
	}
	
	
	/*@RequestMapping(value="/listLieuBydep", params= {"dep"}, method = RequestMethod.GET)
	public String infoLieu (@RequestParam(value="dep") int dep, Model model) {
		
		List<Lieu> llieu = proImp.getBydep(dep);
		model.addAttribute("Listl", llieu);
		return "listBydep";
		
	}*/
	
	
	

}
