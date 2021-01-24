package com.follytech.bankaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.follytech.bankaccount.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
