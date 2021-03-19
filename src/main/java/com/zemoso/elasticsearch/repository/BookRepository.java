package com.zemoso.elasticsearch.repository;

import com.zemoso.elasticsearch.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    Page<Book> findByNameContainingIgnoreCaseOrAuthorIgnoreCase(String name, String authorName, Pageable pageable);
}
