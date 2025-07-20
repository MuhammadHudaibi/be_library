package com.library.demo.controller;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;
import com.library.demo.dto.response.CommonResponse;
import com.library.demo.service.BookService;
import com.library.demo.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<CommonResponse<BookResponse>> createBook(@RequestBody BookRequest bookRequest) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Berhasil menambbahkan buku.",
                bookService.createBook(bookRequest)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<BookResponse>>> getBooks() {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil mendapatkan daftar buku.",
                bookService.getBooks()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<BookResponse>> getBookById(@PathVariable UUID id) {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Behasil mendapatkan buku berdasarkan ID.",
                bookService.findBookById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<BookResponse>> updateBook(@PathVariable UUID id, @RequestBody BookRequest bookRequest) {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil memperbaharui buku.",
                bookService.updateBook(id, bookRequest)
        );
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse<String>> deleteBookById(@RequestBody UUID id) {
        bookService.deleteBookById(id);
        return ResponseUtil.createResponse(
                HttpStatus.NO_CONTENT,
                "Buku berhasil dihapus.",
                null
        );
    }
}
