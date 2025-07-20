package com.library.demo.controller;

import com.library.demo.dto.request.BorrowingTransactionRequest;
import com.library.demo.dto.response.BorrowingTransactionResponse;
import com.library.demo.dto.response.CommonResponse;
import com.library.demo.service.BorrowingTransactionService;
import com.library.demo.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-transaction")
@RequiredArgsConstructor
public class BorrowingTransactionController {

    private final BorrowingTransactionService borrowingTransactionService;

    @PostMapping("/borrow")
    public ResponseEntity<CommonResponse<BorrowingTransactionResponse>> borrowBook(@RequestBody BorrowingTransactionRequest request) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Berhasil meminjam buku.",
                borrowingTransactionService.borrowBook(request)
        );
    }

    @PostMapping("/return")
    public ResponseEntity<CommonResponse<BorrowingTransactionResponse>> returnBook(@RequestBody BorrowingTransactionRequest request) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Berhasil mengembalikan buku.",
                borrowingTransactionService.returnBook(request)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<BorrowingTransactionResponse>>> getBorrowingTransactions() {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar transaksi peminjaman didapatkan",
                borrowingTransactionService.listBorrowingTransactions()
        );
    }
}
