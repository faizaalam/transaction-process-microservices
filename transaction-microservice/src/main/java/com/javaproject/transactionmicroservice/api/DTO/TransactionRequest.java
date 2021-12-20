package com.javaproject.transactionmicroservice.api.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;


public class TransactionRequest implements Serializable {
    @NotBlank(message = "Request ID cannot be null/empty")
    private String requestId;
    @NotBlank(message = "Requester name cannot be null/empty")
    private String requester;
    @NotBlank(message = "Transaction type cannot be null/empty")
    private String transactionType;
    @NotBlank(message = "Source account number cannot be null/empty")
    private String sourceAccountNumber;
    @Positive(message = "Transaction amount not found") private String amount;
    @NotBlank(message = "Destination account number cannot be null/empty")
    private String destinationAccountNumber;
    @NotBlank(message = "Not is mandatory")
    private String note;

    public String getRequestId() {
        return requestId;
    }

    public TransactionRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequester() {
        return requester;
    }

    public TransactionRequest setRequester(String requester) {
        this.requester = requester;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public TransactionRequest setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public TransactionRequest setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public TransactionRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public TransactionRequest setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
        return this;
    }

    public String getNote() {
        return note;
    }

    public TransactionRequest setNote(String note) {
        this.note = note;
        return this;
    }
}
