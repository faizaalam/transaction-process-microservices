package com.javaproject.transactionmicroservice.service.impl;

import com.javaproject.transactionmicroservice.api.DTO.TransactionRequest;
import com.javaproject.transactionmicroservice.repository.AccountRepository;
import com.javaproject.transactionmicroservice.repository.TransactionRequestRepository;
import com.javaproject.transactionmicroservice.repository.schema.TransactionRequestEntity;
import com.javaproject.transactionmicroservice.repository.schema.TransactionType;
import com.javaproject.transactionmicroservice.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Base64;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRequestRepository transactionRequestRepository;
    private final AccountServiceImpl accountService;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRequestRepository transactionRequestRepository, AccountServiceImpl accountService, AccountRepository accountRepository) {
        this.transactionRequestRepository = transactionRequestRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }



    @Transactional
    @Override
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

    @Transactional
    @Override
    public boolean isRequestValid(TransactionRequest transactionRequest) {
        if (!accountRepository.existsByAccountNumber(transactionRequest.getSourceAccountNumber())) {
            return false;
        }
        if (!accountRepository.existsByAccountNumber(transactionRequest.getDestinationAccountNumber())) {
            return false;
        }
        if (transactionRequest.getTransactionType().equals(String.valueOf(TransactionType.TRANSFER)) &&
                !accountRepository.existsAccountEntityByAccountNumberAndBalanceGreaterThan(transactionRequest.getSourceAccountNumber(), Double.valueOf( transactionRequest.getAmount()))) {
            return false;
        }

        if (transactionRequest.getTransactionType().equals(String.valueOf(TransactionType.REVERT)) &&
                !accountRepository.existsAccountEntityByAccountNumberAndBalanceGreaterThan(transactionRequest.getDestinationAccountNumber(), Double.valueOf( transactionRequest.getAmount()))) {
            return false;
        }
        return true;
    }


    private String decodeBase64(String encodedValue) {
        return new String( Base64.getDecoder().decode(encodedValue.getBytes()));
    }
}
