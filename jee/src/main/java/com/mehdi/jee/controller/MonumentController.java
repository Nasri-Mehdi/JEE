package com.mehdi.jee.controller;

import java.text.DecimalFormat;
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
import com.mehdi.jee.entity.Monument;

@Controller
@RequestMapping(value="/Monument")
public class MonumentController {
	
	@Autowired
	private ProImp proImp;
	
	
	
	@RequestMapping(value="/listMonument", method=RequestMethod.GET)
	public String listMonu(Model model) {
		
		List<Monument> lmonu = proImp.findAllM();
		model.addAttribute("listMonu", lmonu);
		return "listMonument";
	}
	
	
	@RequestMapping(value="/listMonumentU", method=RequestMethod.GET)
	public String listMonuU(Model model) {
		
		List<Monument> lmonu = proImp.findAllM();
		model.addAttribute("listMonu", lmonu);
		return "listMonumentU";
	}
	
	
	/*@RequestMapping(value="/rechercheU")
	public String search(Model model, String nomCom) {
		
		List<Monument> Bylieu = proImp.getMonumentByLieu("%"+nomCom+"%");
		model.addAttribute("listMonu", Bylieu);
		return "listMonumentU";
	}*/
	
	
	
	@RequestMapping(value="/ChargerMonument", method = RequestMethod.GET)
	public String ChargerMonument(Model model) {
		model.addAttribute("MonuF", new Monument());
		return "chargMonu";
	}
	
	@PostMapping(value="/ajouteMonu")
	public String ajoutMonu (Model model, @ModelAttribute("MonuF") Monument chMonu) {
		proImp.save(chMonu);
		
		List<Monument> lmonus = proImp.findAllM();
		model.addAttribute("listMonu", lmonus);
		return "listMonument";
	}
	
	
	
	//Modification
	@RequestMapping(value="/modification", params= {"codeM"})
	public String ModifiMonu(@RequestParam(value="codeM") String codeM, Model model) {
		
		Monument editmonu = proImp.getMonument(codeM);
		model.addAttribute("modificationMF", editmonu);
		return "modifiMonu";
			
	}
		
	@RequestMapping(value="/modifications", method = RequestMethod.POST) 
	public String editMonu(@ModelAttribute("modificationM") Monument updatemonu) {
		proImp.update(updatemonu);
		return "redirect:/Monument/listMonument";
	}
	
	
	
	@RequestMapping(value="/List", params= {"codeM"})
	public String infoLieu(@RequestParam(value="codeM") String codeM, Model model) {
		
		Monument listlieu = proImp.getMonument(codeM);
		model.addAttribute("ListMF", listlieu);
		return "listByMonu";
	}
	
	
	@RequestMapping(value="/ListU", params= {"codeM"})
	public String infoLieuU(@RequestParam(value="codeM") String codeM, Model model) {
		
		Monument listlieu = proImp.getMonument(codeM);
		model.addAttribute("ListMF", listlieu);
		return "listByMonuU";
	}
	
	
	@RequestMapping(value="/Supprimer")
	public String suppMonument(String codeM) {
		proImp.deleteM(codeM);
		return "redirect:listMonument";
	}
	
	
	
	
	@RequestMapping(value="/distance")
	public String vpage(Model model) {
		List<Monument> lmonu = proImp.findAllM();
		model.addAttribute("monu1", lmonu);
		model.addAttribute("monu2", lmonu);
		
		model.addAttribute("m1", new Monument());
		//model.addAttribute("m2", new Monument());
		
		return "distance";
	}
	
	@RequestMapping(value="/distance", method=RequestMethod.POST)
	public String DistanceM(@ModelAttribute("m1") Monument m1, Model model) {
		List<Monument> lmonu = proImp.findAllM();
		model.addAttribute("monu1", lmonu);
		model.addAttribute("monu2", lmonu);
		
		double distance = proImp.getDistanceBetweenMonument(m1.getNomM());
		DecimalFormat df = new DecimalFormat("#.##");
		model.addAttribute("distance", df.format(distance));
		
		return "distance";
		
	}
	
	
	

}
