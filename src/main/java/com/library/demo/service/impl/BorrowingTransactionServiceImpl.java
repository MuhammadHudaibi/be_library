package com.library.demo.service.impl;

import com.library.demo.constant.StatusTransaction;
import com.library.demo.dto.request.BorrowingTransactionRequest;
import com.library.demo.dto.response.BorrowingTransactionResponse;
import com.library.demo.entity.Book;
import com.library.demo.entity.BorrowingTransaction;
import com.library.demo.entity.Member;
import com.library.demo.mapper.BorrowingTransactionMapper;
import com.library.demo.repository.BookRepository;
import com.library.demo.repository.BorrowingTransactionRepository;
import com.library.demo.service.BorrowingTransactionService;
import com.library.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowingTransactionServiceImpl implements BorrowingTransactionService {

    private final BorrowingTransactionRepository borrowingTransactionRepository;
    private final BookRepository bookRepository;
    private final MemberService memberService;

    @Override
    public BorrowingTransactionResponse borrowBook(BorrowingTransactionRequest request) {
        Book book = bookRepository.findById(request.getBookId()).orElse(null);
        Member member = memberService.findById(request.getMemberId());
        if (book == null || member == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku/member tidak ditemukan");
        }

        if (book.getStock() <= 0){
            throw new RuntimeException("Stock habis");
        }

        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        BorrowingTransaction borrowingTransaction = BorrowingTransaction.builder()
                .book(book)
                .member(member)
                .statusTransaction(StatusTransaction.DIPINJAM)
                .returnDate(null)
                .build();

        borrowingTransactionRepository.save(borrowingTransaction);

        return BorrowingTransactionMapper.toBorrowingTransactionResponse(borrowingTransaction);
    }

    @Override
    public BorrowingTransactionResponse returnBook(BorrowingTransactionRequest request) {
        BorrowingTransaction borrowingTransaction = borrowingTransactionRepository.findById(request.getTransactionId()).orElse(null);

        if (borrowingTransaction == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaksi tidak ditemukan");
        }

        if (borrowingTransaction.getStatusTransaction() == StatusTransaction.KEMBALI){
            throw new RuntimeException("Buku sudah dikembalikan");
        }

        Book book = bookRepository.findById(borrowingTransaction.getBook().getId()).orElse(null);
        if (book != null){
            book.setStock(book.getStock() + 1);
            bookRepository.save(book);
        }

        borrowingTransaction.setBook(book);
        borrowingTransaction.setReturnDate(LocalDate.now());
        borrowingTransaction.setStatusTransaction(StatusTransaction.KEMBALI);

        borrowingTransactionRepository.save(borrowingTransaction);

        return BorrowingTransactionMapper.toBorrowingTransactionResponse(borrowingTransaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BorrowingTransactionResponse> listBorrowingTransactions() {
        List<BorrowingTransaction> borrowingTransactions = borrowingTransactionRepository.findAll();
        return borrowingTransactions
                .stream()
                .map(BorrowingTransactionMapper::toBorrowingTransactionResponse)
                .collect(Collectors.toList());
    }
}