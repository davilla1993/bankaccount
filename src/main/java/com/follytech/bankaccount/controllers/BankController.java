package com.follytech.bankaccount.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.follytech.bankaccount.entities.Compte;
import com.follytech.bankaccount.entities.Operation;
import com.follytech.bankaccount.services.IBanqueServices;

@Controller
public class BankController {
	
	@Autowired
	private IBanqueServices banqueServices;
	
	@RequestMapping("/operations")
	public String index() {
		
		return "comptes";
		
	}
	
	
	@RequestMapping("/consulterCompte")
	public String consulter(Model model, String codeCompte, @RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="size", defaultValue="5")int size) {
		
		model.addAttribute("codeCompte", codeCompte);
		
	 try {
		Compte cp = banqueServices.consulterCompte(codeCompte);
		
		Page<Operation> pageOperations = banqueServices.listOperation(codeCompte, page, size);
		
		model.addAttribute("compte", cp);
		model.addAttribute("listOperations", pageOperations.getContent());
		
		int[] pages = new int[pageOperations.getTotalPages()];
		
		model.addAttribute("pages", pages);
		
	 } catch(Exception e) {
		 
		 model.addAttribute("exception", e);
		 
	 }
	 
		return "comptes";

		
	}
	
	
	@PostMapping("/saveOperation")
	public String saveOperation(Model model, String typeOperation, String codeCompte, double montant, String codeCompte2 ) {
		
		
	try {
		
		if(typeOperation.equals("vers")) {
			
			banqueServices.verser(codeCompte, montant);
			
		} else if (typeOperation.contentEquals("retr")) {
			
			banqueServices.retirer(codeCompte, montant);
			
		} else if(typeOperation.equals("vire")) {
			
			banqueServices.virement(codeCompte, codeCompte2, montant); 
			
		}
					
	} catch(Exception e) {
		
		model.addAttribute("error", e);
		return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();

	}
		
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	

}
