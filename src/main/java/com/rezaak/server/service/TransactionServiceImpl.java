package com.rezaak.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rezaak.server.model.Transaction;
import com.rezaak.server.repository.TransactionRepositorty;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepositorty transactionRepository;
	
	@Override
	public Transaction saveTransaction(final Transaction transaction) {
		return transactionRepository.save(transaction);
		 
	}
	
	
	@Override
	public Long numberOfTransactions() {
		return transactionRepository.count();
	}
	
	@Override
	public List<Transaction> findAllTransactions(){
		return transactionRepository.findAll();
		
	}
	
}
