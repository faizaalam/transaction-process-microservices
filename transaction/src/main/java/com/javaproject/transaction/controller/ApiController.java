package com.javaproject.transaction.controller;

import com.javaproject.transaction.api.DTO.TransactionDTO;
import com.javaproject.transaction.api.service.TransactionServiceProxy;
import feign.FeignException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis")
public class ApiController {
    private final TransactionServiceProxy transactionServiceProxy;

    public ApiController(TransactionServiceProxy transactionServiceProxy) {
        this.transactionServiceProxy = transactionServiceProxy;
    }

    @PostMapping(path = "/do-transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doTransaction(@RequestBody TransactionDTO transactionDTO) {
        try {
            transactionServiceProxy.doTransactions(transactionDTO);
        } catch (FeignException e) {
            return ResponseEntity.ok().body(e.contentUTF8());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> initialResponse() {
        return ResponseEntity.ok("Application is running");
    }


}
