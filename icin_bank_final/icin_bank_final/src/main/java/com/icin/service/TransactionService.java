package com.icin.service;

import java.util.List;

import com.icin.model.PersonalTransaction;
import com.icin.model.PrimaryAccount;
import com.icin.model.Transaction;

public interface TransactionService {

    //public List<Transaction> retrieveTransactionsForAccount(long accountId);
    
    public void transferMoney(Transaction transaction);
    
    public int retreiveAccountNumber(Long id);
    List<PersonalTransaction> retrieveTransactionsAccount(int accountNumber);
	List<Transaction> retrieveTransactionsForAccount(int accountNumber);
}
