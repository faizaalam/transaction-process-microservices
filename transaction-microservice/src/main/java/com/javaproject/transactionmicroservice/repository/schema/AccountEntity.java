package com.javaproject.transactionmicroservice.repository.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long  id;
    private String name;
    private String  address;
    private String  accountNumber;
    private Double   balance;
    private String  status;

    public Long getId() {
        return id;
    }

    public AccountEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AccountEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountEntity setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountEntity setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public AccountEntity setStatus(String status) {
        this.status = status;
        return this;
    }
}
