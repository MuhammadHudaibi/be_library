package com.library.demo.service;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest);
    List<BookResponse> getBooks();
}
