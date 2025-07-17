package com.library.demo.controller;

import com.library.demo.dto.request.BorrowingTransactionRequest;
import com.library.demo.dto.response.BorrowingTransactionResponse;
import com.library.demo.service.BorrowingTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-transaction")
@RequiredArgsConstructor
public class BorrowingTransactionController {

    private final BorrowingTransactionService borrowingTransactionService;

    @PostMapping("/borrow")
    public BorrowingTransactionResponse borrowBook(@RequestBody BorrowingTransactionRequest request) {
        return borrowingTransactionService.borrowBook(request);
    }

    @PostMapping("/return")
    public BorrowingTransactionResponse returnBook(@RequestBody BorrowingTransactionRequest request) {
        return borrowingTransactionService.returnBook(request);
    }

    @GetMapping
    public List<BorrowingTransactionResponse> getBorrowingTransactions() {
        return borrowingTransactionService.listBorrowingTransactions();
    }
}
