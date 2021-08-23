package com.example.springcachingredis.service;

import com.example.springcachingredis.entity.BookEntity;
import com.example.springcachingredis.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImp implements BookService{

        private static final Logger logger = LoggerFactory.getLogger(BookServiceImp.class);
        @Autowired
        private BookRepository bookRepository;

        @Override
        public BookEntity addBook(BookEntity book) {
            logger.info("adding book with id - {}", book.getId());
            return bookRepository.save(book);
        }

        @Override
        @CachePut(cacheNames = "books", key = "#book.id")
        public BookEntity updateBook(BookEntity book) {
            bookRepository.updateAddress(book.getId(), book.getName());
            logger.info("book updated with new name");
            return book;
        }

        @Override
        @Cacheable(cacheNames = "books", key = "#id")
        public BookEntity getBook(long id) {
            logger.info("fetching book from db");
            Optional<BookEntity> book = bookRepository.findById(id);
            if (book.isPresent()) {
                return book.get();
            } else {
                return new BookEntity();
            }
        }

        @Override
        @CacheEvict(cacheNames = "books", key = "#id")
        public String deleteBook(long id) {
            bookRepository.deleteById(id);
            return "Book deleted";
        }

    }