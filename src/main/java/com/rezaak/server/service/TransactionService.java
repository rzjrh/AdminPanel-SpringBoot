package com.rezaak.server.service;

import java.util.List;

import com.rezaak.server.model.Transaction;

public interface TransactionService {

	Transaction saveTransaction(Transaction transaction);

	Long numberOfTransactions();

	List<Transaction> findAllTransactions();

}
