package com.javaproject.transactionmicroservice.controller;

import com.javaproject.transactionmicroservice.api.DTO.TransactionRequest;
import com.javaproject.transactionmicroservice.service.TransactionServiceImpl;
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

    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        transactionService.doTransaction(transactionRequest);
        return ResponseEntity.ok("Application is running");
    }
}
