package org.pratice.book.domain.dto;

import lombok.Getter;

@Getter
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private String publishedDate;
    private String isbn;
}
