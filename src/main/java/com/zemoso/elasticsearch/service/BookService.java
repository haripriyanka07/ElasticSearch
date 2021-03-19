package com.zemoso.elasticsearch.service;

import com.zemoso.elasticsearch.entity.Book;
import com.zemoso.elasticsearch.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public Page<Book> getBooks(String keyword) {
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 10;
            }

            @Override
            public long getOffset() {
                return 0;
            }
            //sorting by total pages
            @Override
            public Sort getSort() {
                return Sort.by("totalPages").ascending();
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        if (keyword != null)
            return bookRepository.findByNameContainingIgnoreCaseOrAuthorIgnoreCase(keyword, keyword, pageable);
        return bookRepository.findAll(pageable);
    }

    public void setBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public void deleteBooks() {
        bookRepository.deleteAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }
}
