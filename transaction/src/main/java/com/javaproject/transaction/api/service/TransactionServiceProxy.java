package com.javaproject.transaction.api.service;

import com.javaproject.transaction.api.DTO.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transaction-service")
public interface TransactionServiceProxy {
    @PostMapping("perform-transactions")
    public ResponseEntity<?> doTransactions(@RequestBody TransactionDTO transactionDTO);
}
