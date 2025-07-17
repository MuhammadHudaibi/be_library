package com.library.demo.service.impl;

import com.library.demo.dto.request.BookRequest;
import com.library.demo.dto.response.BookResponse;
import com.library.demo.entity.Book;
import com.library.demo.mapper.BookMapper;
import com.library.demo.repository.BookRepository;
import com.library.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .publisher(bookRequest.getPublisher())
                .yearPublished(bookRequest.getYearPublished())
                .stock(bookRequest.getStock())
                .build();
        bookRepository.save(book);
        return BookMapper.toBookResponse(book);
    }

    @Override
    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toBookResponse).collect(Collectors.toList());
    }
}
