package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDaoInterface {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "author", column = "author"),
            @Result(property = "publisher", column = "publisher")
    })

    @Delete("delete * from tb_book where id=#{id}")
    boolean deleteBookByid(Integer id);

    @Select("select * from tb_book where id=#{id}")
    Book getBookByid(Integer id);

    @Select("select * from tb_book")
    List<Book> getBookList();

    @Insert("insert into tb_book(id, name, author, publisher) VALUES (#{id}, #{name}, #{author}, #{publisher})")
    int addBook(Book book);

    @Update("update tb_book SET name=#{name} WHERE id =#{id}")
    void updateBook(Book book);

}
