package com.javaproject.transactionmicroservice.service;

import com.javaproject.transactionmicroservice.repository.schema.TransactionType;


public interface AccountService {
    void updateSourceAccountBalances(String accountNumber, Double transactionAmount, TransactionType transactionType);

    void updateDestinationAccountBalances(String accountNumber, Double transactionAmount, TransactionType transactionType);

}
