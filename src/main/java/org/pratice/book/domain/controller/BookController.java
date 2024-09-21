package org.pratice.book.domain.controller;

import lombok.RequiredArgsConstructor;
import org.pratice.book.domain.dto.BookEditRequest;
import org.pratice.book.domain.dto.BookRequest;
import org.pratice.book.domain.dto.BookResponse;
import org.pratice.book.domain.entity.Book;
import org.pratice.book.domain.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> searchBook()
    {
        List<Book> books = bookService.searchBook();
        return ResponseEntity.ok(books);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Book> searchIdBook(@PathVariable Long Id)
    {
        Book book = bookService.searchIdBook(Id);
        return ResponseEntity.ok(book);
    }
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request)
    {
        BookResponse book = bookService.createBook(request);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<Void> EditBooks(@PathVariable Long Id, @RequestBody BookEditRequest request)
    {
        bookService.EditBooks(Id,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> DeleteBooks(@PathVariable Long Id)
    {
        bookService.DeleteBook(Id);
        return ResponseEntity.status(204).build();
    }
}
