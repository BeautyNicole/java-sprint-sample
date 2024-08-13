package com.itheima.domain;

import lombok.Data;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

@Data
public class Book implements Serializable, Comparable<Book> {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private Double price;

    @Override
    public int compareTo(Book o) {
        return Double.compare(this.price, o.getPrice());
    }
}
