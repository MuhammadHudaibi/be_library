package com.library.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingTransactionRequest {
    private UUID bookId;
    private UUID memberId;
    private UUID transactionId;
}
