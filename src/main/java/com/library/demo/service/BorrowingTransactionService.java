package com.library.demo.service;

import com.library.demo.dto.request.BorrowingTransactionRequest;
import com.library.demo.dto.response.BorrowingTransactionResponse;

import java.util.List;
import java.util.UUID;

public interface BorrowingTransactionService {
    BorrowingTransactionResponse borrowBook(BorrowingTransactionRequest request);
    BorrowingTransactionResponse returnBook(BorrowingTransactionRequest request);
    List<BorrowingTransactionResponse> listBorrowingTransactions();
}
