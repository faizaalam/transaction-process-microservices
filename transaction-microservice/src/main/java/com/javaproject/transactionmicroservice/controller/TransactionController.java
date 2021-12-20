package com.javaproject.transactionmicroservice.controller;

import com.javaproject.transactionmicroservice.api.DTO.TransactionRequest;
import com.javaproject.transactionmicroservice.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/perform-transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doTransaction(@RequestBody TransactionRequest transactionRequest) {
        if (!transactionService.isRequestValid(transactionRequest)) {
            throw new RuntimeException("Transaction request is not valid");
        }

       try {
           transactionService.doTransaction(transactionRequest);
       }catch (Exception e) {
           throw new RuntimeException("Transaction could not be performed");
       }
        return ResponseEntity.ok().build();
    }
}
