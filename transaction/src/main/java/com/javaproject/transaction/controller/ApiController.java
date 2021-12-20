package com.javaproject.transaction.controller;

import com.javaproject.transaction.api.DTO.TransactionDTO;
import com.javaproject.transaction.api.service.TransactionServiceProxy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/apis")
public class ApiController {
    private final TransactionServiceProxy transactionServiceProxy;

    public ApiController(TransactionServiceProxy transactionServiceProxy) {
        this.transactionServiceProxy = transactionServiceProxy;
    }

    @PostMapping(path = "/do-transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> doTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionServiceProxy.doTransactions(transactionDTO);
        return ResponseEntity.ok().body("Hi");
    }
    @GetMapping
    public ResponseEntity<?> initialResponse() {
        return ResponseEntity.ok("Application is running");
    }


}
