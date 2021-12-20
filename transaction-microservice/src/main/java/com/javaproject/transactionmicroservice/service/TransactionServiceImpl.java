package com.javaproject.transactionmicroservice.service;

import com.javaproject.transactionmicroservice.api.DTO.TransactionRequest;
import com.javaproject.transactionmicroservice.repository.TransactionRequestRepository;
import com.javaproject.transactionmicroservice.repository.schema.TransactionRequestEntity;
import com.javaproject.transactionmicroservice.repository.schema.TransactionType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Base64;

@Service
public class TransactionServiceImpl {
    private final TransactionRequestRepository transactionRequestRepository;
    private final AccountServiceImpl accountService;

    public TransactionServiceImpl(TransactionRequestRepository transactionRequestRepository, AccountServiceImpl accountService) {
        this.transactionRequestRepository = transactionRequestRepository;
        this.accountService = accountService;
    }

    @Transactional
    public void doTransaction(TransactionRequest transactionRequest) {
        TransactionRequestEntity transactionRequestEntity = new TransactionRequestEntity()
                .setRequestId(transactionRequest.getRequestId())
                .setRequester(transactionRequest.getRequester())
                .setNote(transactionRequest.getNote())
                .setTransactionType(TransactionType.valueOf(decodeBase64(transactionRequest.getTransactionType())))
                .setAmount(Double.valueOf(decodeBase64(transactionRequest.getAmount())))
                .setDestinationAccountNumber(decodeBase64(transactionRequest.getDestinationAccountNumber()))
                .setSourceAccountNumber(decodeBase64(transactionRequest.getSourceAccountNumber()));

        transactionRequestEntity = transactionRequestRepository.save(transactionRequestEntity);

        accountService.updateSourceAccountBalances(transactionRequestEntity.getSourceAccountNumber(), transactionRequestEntity.getAmount(), transactionRequestEntity.getTransactionType());
        accountService.updateDestinationAccountBalances(transactionRequestEntity.getDestinationAccountNumber(), transactionRequestEntity.getAmount(), transactionRequestEntity.getTransactionType());

    }

    private String decodeBase64(String encodedValue) {
        return new String( Base64.getDecoder().decode(encodedValue.getBytes()));
    }
}
