package com.library.demo.repository;

import com.library.demo.entity.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransaction, UUID> {
}
