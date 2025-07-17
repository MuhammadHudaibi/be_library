package com.library.demo.entity;

import com.library.demo.constant.StatusTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private StatusTransaction statusTransaction;

    @PrePersist
    public void prePersist()
    {
        this.borrowingDate = LocalDate.now();
    }
}
