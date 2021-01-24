package com.follytech.bankaccount.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Retrait extends Operation{

	private static final long serialVersionUID = -4155068724970490679L;

	public Retrait() {
		super();

	}

	public Retrait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);

	}
	
	

}
