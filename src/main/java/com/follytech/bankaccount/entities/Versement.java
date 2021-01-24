package com.follytech.bankaccount.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Versement extends Operation{

	private static final long serialVersionUID = 6212014718417011639L;

	public Versement() {
		super();

	}

	public Versement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);

	}
	
	

}
