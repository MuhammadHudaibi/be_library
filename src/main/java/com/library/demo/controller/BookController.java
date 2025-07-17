package com.library.demo.controller;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;
import com.library.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponse createBook(@RequestBody BookRequest bookRequest) {
        return bookService.createBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }
}
