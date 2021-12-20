package com.javaproject.transaction.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class TransactionDTO implements Serializable {
   @NotNull private String requestId;
    @NotNull private String requester;
    @NotNull private byte[] transactionType;
    @NotNull private byte[] sourceAccountNumber;
    @NotNull private byte[] amount;
    @NotNull  private byte[] destinationAccountNumber;
    @NotNull private String note;

 public String getRequestId() {
  return requestId;
 }

 public TransactionDTO setRequestId(String requestId) {
  this.requestId = requestId;
  return this;
 }

 public String getRequester() {
  return requester;
 }

 public TransactionDTO setRequester(String requester) {
  this.requester = requester;
  return this;
 }

 public byte[] getTransactionType() {
  return transactionType;
 }

 public TransactionDTO setTransactionType(byte[] transactionType) {
  this.transactionType = transactionType;
  return this;
 }

 public byte[] getSourceAccountNumber() {
  return sourceAccountNumber;
 }

 public TransactionDTO setSourceAccountNumber(byte[] sourceAccountNumber) {
  this.sourceAccountNumber = sourceAccountNumber;
  return this;
 }

 public byte[] getAmount() {
  return amount;
 }

 public TransactionDTO setAmount(byte[] amount) {
  this.amount = amount;
  return this;
 }

 public byte[] getDestinationAccountNumber() {
  return destinationAccountNumber;
 }

 public TransactionDTO setDestinationAccountNumber(byte[] destinationAccountNumber) {
  this.destinationAccountNumber = destinationAccountNumber;
  return this;
 }

 public String getNote() {
  return note;
 }

 public TransactionDTO setNote(String note) {
  this.note = note;
  return this;
 }
}
