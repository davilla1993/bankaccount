package com.follytech.bankaccount.servicesImpl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.follytech.bankaccount.dao.CompteRepository;
import com.follytech.bankaccount.dao.OperationRepository;
import com.follytech.bankaccount.entities.Compte;
import com.follytech.bankaccount.entities.CompteCourant;
import com.follytech.bankaccount.entities.Operation;
import com.follytech.bankaccount.entities.Retrait;
import com.follytech.bankaccount.entities.Versement;
import com.follytech.bankaccount.services.IBanqueServices;

@Service
@Transactional
public class IBanqueServiceImpl implements IBanqueServices{
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
						
		return compteRepository.findById(codeCpte)
					.orElseThrow(()-> new RuntimeException("Ce compte n'existe pas"));
	}

	@Override
	public void verser(String codeCpte, double montant) {

		Compte  cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp );
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		
		Compte  cp = consulterCompte(codeCpte);
		
		double facilitesCaisse = 0;
		
		if(cp instanceof CompteCourant) 
			
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
			
		if( cp.getSolde()+facilitesCaisse < montant) 
			
			throw new RuntimeException("Solde insuffisant");
			
		Retrait r = new Retrait(new Date(), montant, cp );
		
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		 
		compteRepository.save(cp);		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {

		if(codeCpte1.equals(codeCpte2)) {
			throw new RuntimeException("Impossible virement sur le même compte");
		}
		
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {

		return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
	}

}
