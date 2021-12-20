package com.javaproject.transactionmicroservice.repository;

import com.javaproject.transactionmicroservice.repository.schema.TransactionRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRequestRepository extends JpaRepository<TransactionRequestEntity, Long> {
}
