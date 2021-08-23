package com.example.springcachingredis.service;

import com.example.springcachingredis.entity.BookEntity;

public interface BookService {
    BookEntity addBook(BookEntity book);

    BookEntity updateBook(BookEntity book);

    BookEntity getBook(long id);

    String deleteBook(long id);
}