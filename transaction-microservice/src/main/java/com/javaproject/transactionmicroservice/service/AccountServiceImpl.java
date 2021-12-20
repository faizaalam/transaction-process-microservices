package com.javaproject.transactionmicroservice.service;

import com.javaproject.transactionmicroservice.repository.AccountRepository;
import com.javaproject.transactionmicroservice.repository.schema.AccountEntity;
import com.javaproject.transactionmicroservice.repository.schema.TransactionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void updateSourceAccountBalances(String accountNumber, Double transactionAmount, TransactionType transactionType) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new RuntimeException("Source Account not found"));

        switch (transactionType) {
            case TRANSFER:
                accountEntity.setBalance(accountEntity.getBalance() - transactionAmount);
                break;
            case REVERT:
                accountEntity.setBalance(accountEntity.getBalance() + transactionAmount);
                break;
            default:
                break;

        }
        accountRepository.saveAndFlush(accountEntity);
    }

    @Transactional
    public void updateDestinationAccountBalances(String accountNumber, Double transactionAmount, TransactionType transactionType) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new RuntimeException("Destination Account not found"));

        switch (transactionType) {
            case REVERT:
                accountEntity.setBalance(accountEntity.getBalance() - transactionAmount);
                break;
            case TRANSFER:
                accountEntity.setBalance(accountEntity.getBalance() + transactionAmount);
                break;
            default:
                break;

        }
        accountRepository.saveAndFlush(accountEntity);
    }
}
