package com.itheima.service.impl;

import com.itheima.dao.BookDaoInterface;
import com.itheima.domain.Book;
import com.itheima.service.BookServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService implements BookServiceInterface {
    //    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookDaoInterface bookDao;

    private List<Book> cachedBookList;

    @Override
    public boolean deleteBookById(int id) {

        return bookDao.deleteBookByid(id);
    }

    @Override
    @Cacheable(value="cachedBook", key="#id")
    public Book getBookById(int id) {
        log.info("getBookById is running...");
        if(cachedBookList != null && cachedBookList.size() > 0) {
            List<Book> filteredBookList = cachedBookList.stream()
                    .filter(b -> b.getId() == id)
                    .collect(Collectors.toList());

            if(filteredBookList !=null && filteredBookList.size() > 0) {
                return filteredBookList.get(0);
            }
        }

        return bookDao.getBookByid(id);
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("getAllBooks is running...");
        return bookDao.getBookList();
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
}
