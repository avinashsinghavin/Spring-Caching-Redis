package com.example.springcachingredis.controller;

import com.example.springcachingredis.entity.BookEntity;
import com.example.springcachingredis.service.BookService;
import com.example.springcachingredis.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {


        @Autowired
        private BookService bookService;

        @PostMapping("/book")
        public BookEntity addBook(@RequestBody BookEntity book) {
            return bookService.addBook(book);
        }

        @PutMapping("/book")
        public BookEntity updateBook(@RequestBody BookEntity book) {
            return bookService.updateBook(book);
        }

        @GetMapping("/book/{id}")
        public BookEntity getBook(@PathVariable long id) {
            return bookService.getBook(id);
        }

        @DeleteMapping("/book/{id}")
        public String deleteBook(@PathVariable long id) {
            return bookService.deleteBook(id);
        }
    }
