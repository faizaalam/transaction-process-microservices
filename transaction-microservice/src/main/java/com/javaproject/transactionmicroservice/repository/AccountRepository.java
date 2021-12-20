package com.javaproject.transactionmicroservice.repository;

import com.javaproject.transactionmicroservice.repository.schema.AccountEntity;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
    Boolean existsByAccountNumber(String accountNumber);
    Boolean existsAccountEntityByAccountNumberAndBalanceGreaterThan(String accountNumber,Double balanceCheck);
}
