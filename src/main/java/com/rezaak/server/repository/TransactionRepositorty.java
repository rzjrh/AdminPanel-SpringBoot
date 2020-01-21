package com.rezaak.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rezaak.server.model.Transaction;

public interface TransactionRepositorty extends JpaRepository<Transaction, Long>{

}
