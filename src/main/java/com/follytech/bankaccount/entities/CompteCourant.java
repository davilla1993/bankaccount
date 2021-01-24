package com.follytech.bankaccount.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

	private static final long serialVersionUID = 227783351206257092L;
	
	private double decouvert;

	public CompteCourant() {
		super();
	}

	

	public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client,
			double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;

	}



	public double getDecouvert() {
		return decouvert;
	}

 

}
