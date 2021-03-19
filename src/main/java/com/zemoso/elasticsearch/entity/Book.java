package com.zemoso.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "book-search")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String id;
    private String name;
    private String author;
    private String publisher;
    private String description;
    private int totalPages;

}
