package com.javaproject.transactionmicroservice.repository.schema;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION_LOGS")
public class TransactionRequestEntity {
    @Id
    private String requestId;
    private String requester;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String sourceAccountNumber;
    private Double amount;
    private String destinationAccountNumber;
    private String note;

    // audit

    public String getRequestId() {
        return requestId;
    }

    public TransactionRequestEntity setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequester() {
        return requester;
    }

    public TransactionRequestEntity setRequester(String requester) {
        this.requester = requester;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public TransactionRequestEntity setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public TransactionRequestEntity setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionRequestEntity setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public TransactionRequestEntity setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
        return this;
    }

    public String getNote() {
        return note;
    }

    public TransactionRequestEntity setNote(String note) {
        this.note = note;
        return this;
    }
}
