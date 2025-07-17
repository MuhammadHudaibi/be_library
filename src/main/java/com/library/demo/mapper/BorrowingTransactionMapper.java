package com.library.demo.mapper;

import com.library.demo.dto.response.BorrowingTransactionResponse;
import com.library.demo.entity.BorrowingTransaction;

public class BorrowingTransactionMapper {
    public static BorrowingTransactionResponse toBorrowingTransactionResponse(BorrowingTransaction borrowingTransaction) {
        return BorrowingTransactionResponse.builder()
                .transactionId(borrowingTransaction.getId())
                .book(BookMapper.toBookResponse(borrowingTransaction.getBook()))
                .member(MemberMapper.toMemberResponse(borrowingTransaction.getMember()))
                .borrowDate(borrowingTransaction.getBorrowingDate())
                .returnDate(borrowingTransaction.getReturnDate())
                .statusTransaction(borrowingTransaction.getStatusTransaction())
                .build();
    }
}
