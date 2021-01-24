package com.follytech.bankaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.follytech.bankaccount.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
