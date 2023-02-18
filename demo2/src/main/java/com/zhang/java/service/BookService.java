package com.zhang.java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhang.java.domain.Book;

import java.util.List;

/**
 * @Date 2023/2/16 21:17
 * @Author zsy
 * @Description
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
