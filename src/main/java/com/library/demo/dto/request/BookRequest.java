package com.library.demo.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private Integer yearPublished;
    private Integer stock;
}
