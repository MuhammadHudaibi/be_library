package com.library.demo.service;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;
import com.library.demo.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
    List<BookResponse> getBooks();
    BookResponse findBookById(UUID id);
    BookResponse updateBook(UUID id, BookRequest bookRequest);
    void deleteBookById(UUID id);
    Book findById(UUID id);
}
