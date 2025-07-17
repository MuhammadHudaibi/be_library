package com.library.demo.dto.response;

import com.library.demo.constant.StatusTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingTransactionResponse {
    private UUID transactionId;
    private BookResponse book;
    private MemberResponse member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private StatusTransaction statusTransaction;
}
