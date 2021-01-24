package com.follytech.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.follytech.bankaccount.dao.ClientRepository;
import com.follytech.bankaccount.dao.CompteRepository;
import com.follytech.bankaccount.dao.OperationRepository;
import com.follytech.bankaccount.entities.Client;
import com.follytech.bankaccount.entities.Compte;
import com.follytech.bankaccount.entities.CompteCourant;
import com.follytech.bankaccount.entities.CompteEpargne;
import com.follytech.bankaccount.entities.Operation;
import com.follytech.bankaccount.entities.Retrait;
import com.follytech.bankaccount.entities.Versement;

@SuppressWarnings("unused")
@SpringBootApplication
public class BankaccountApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
	  
		
	}
	
	
	
/*
	Client cl1 = new Client("Ahmed", "ahmed21@gmail.com");
	Client cl2 = new Client("Kodjo", "kodjoenglish@yahoo.fr");
	Client cl3 = new Client("Ayele", "ayele_afi@laposte.net");
	Client cl4 = new Client("Kokoe", "kokoe.bella@wanadoo.fr");
	Client Josh = new Client("Josh", "josh@gmail.com");
	Client Brayan = new Client("Brayan", "brayan12@hotmail.com");
	
	Compte cJosh = new CompteEpargne("CJ", new Date(), 0, Josh,  1.5);
	Compte cBrayan = new CompteCourant("CB", new Date(), 0, Brayan, 0);
	Compte cpt1 = new CompteCourant("CCCVC1", new Date(), 513000, cl1, 0);
	Compte cpt2 = new CompteEpargne("CEUTY2", new Date(), 890051, cl2, 1.5);
	Compte cpt3 = new CompteEpargne("CETY3", new Date(), 180932, cl3, 1.5);
	Compte c1 = new CompteCourant("C1", new Date(), 34001, cl4, 5000);
	
	Operation op1 = new Versement(new Date(), 5000, cpt1);
	Operation op2 = new Retrait(new Date(), 3000, cpt2);
	
	Operation op3 = new Versement(new Date(), 500, c1);
	Operation op4 = new Versement(new Date(), 100, c1);
	Operation op5 = new Versement(new Date(), 200, c1);
	Operation op6 = new Versement(new Date(), 600, c1);
	Operation op7 = new Versement(new Date(), 2500, c1);
	Operation op8 = new Versement(new Date(), 8000, c1);
	
	Operation op9 = new Retrait(new Date(), 350, c1);
	Operation op10 = new Retrait(new Date(), 500, c1);
	Operation op11 = new Retrait(new Date(), 750, c1);

*/	
	
	


	

	@Override
	public void run(String... args) throws Exception {
		
/*	
	clientRepository.save(cl1);
	clientRepository.save(cl2);
	clientRepository.save(cl3);
	clientRepository.save(cl4);
		
	clientRepository.save(Josh);
	clientRepository.save(Brayan);
	
	compteRepository.save(cpt1);
	compteRepository.save(cpt2);
	compteRepository.save(cpt3);
	compteRepository.save(c1);
	compteRepository.save(cJosh);
	compteRepository.save(cBrayan);
	
	operationRepository.save(op1);
	operationRepository.save(op2);
	operationRepository.save(op3);
	operationRepository.save(op4);
	operationRepository.save(op5);
	operationRepository.save(op6);
	operationRepository.save(op7);
	operationRepository.save(op8);
	operationRepository.save(op9);
	operationRepository.save(op10);
	operationRepository.save(op11);

*/
	
	
	
		
	}
	
}
	
	
