package com.library.demo.mapper;

import com.library.demo.dto.response.BookResponse;
import com.library.demo.entity.Book;

public class BookMapper {
    public static BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .bookId(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }
}
