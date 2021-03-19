package com.zemoso.elasticsearch.controller;

import com.zemoso.elasticsearch.entity.Book;
import com.zemoso.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable String bookId) throws Exception {
        Optional<Book> getBook = bookService.getBookById(bookId);
        if (getBook.isPresent()) {
            return getBook.get();
        }else {
            throw new Exception("Book Doesn't Exist");
        }
    }

    @GetMapping
    public Page<Book> getBooks(@RequestParam (required = false) String keyword) {
        return bookService.getBooks(keyword);
    }

    @PostMapping
    public int saveBook(@RequestBody List<Book> books) {
        bookService.setBooks(books);
        return books.size();
    }

    @DeleteMapping
    public void deleteBooks() {
        bookService.deleteBooks();
    }
}
