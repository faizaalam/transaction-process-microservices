package com.javaproject.transactionmicroservice.service;

import com.javaproject.transactionmicroservice.api.DTO.TransactionRequest;


public interface TransactionService {
    void doTransaction(TransactionRequest transactionRequest);

    boolean isRequestValid(TransactionRequest transactionRequest);
}
