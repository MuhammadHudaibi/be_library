package com.library.demo.controller;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;
import com.library.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable UUID id) {
        return bookService.findBookById(id);
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable UUID id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping
    public void deleteBookById(@RequestBody UUID id) {
        bookService.deleteBookById(id);
    }
}
