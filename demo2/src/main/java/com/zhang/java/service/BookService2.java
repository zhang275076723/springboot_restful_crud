package com.zhang.java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.java.domain.Book;

/**
 * @Date 2023/2/16 21:36
 * @Author zsy
 * @Description mp业务层，不推荐使用
 */
public interface BookService2 extends IService<Book> {
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
