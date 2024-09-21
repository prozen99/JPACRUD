package org.pratice.book.domain.service;

import lombok.RequiredArgsConstructor;
import org.pratice.book.domain.dto.BookEditRequest;
import org.pratice.book.domain.dto.BookRequest;
import org.pratice.book.domain.dto.BookResponse;
import org.pratice.book.domain.entity.Book;
import org.pratice.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> searchBook() {
        return bookRepository.findAll();
    }

    public Book searchIdBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("찾고자 하는 책의 아이디가 없습니다"));
        return book;
    }

    public BookResponse createBook(BookRequest request) {
        Book book=new Book();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setPublisher(request.getPublisher());
        book.setPublishDate(request.getPublishedDate());
        book.setAuthor(request.getAuthor());
        bookRepository.save(book);
        return new BookResponse(
                book.getBookid(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublishDate(),
                book.getIsbn()
        );

    }

    public void EditBooks(Long id, BookEditRequest request)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("수정할 책이 존재하지 않습니다"));
        book.setTitle(request.getTitle());// 제목만 수정
        bookRepository.save(book);
    }
    public void DeleteBook(Long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("삭제할 책이 존재하지 않습니다"));
        bookRepository.delete(book);
    }

}
