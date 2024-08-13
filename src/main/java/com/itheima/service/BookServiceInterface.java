package com.itheima.service;

import com.itheima.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookServiceInterface {
    boolean deleteBookById(int id);

    Book getBookById(int id);

    List<Book> getAllBooks();

    int addBook(Book book);

    void updateBook(Book book);
}
