package com.zhang.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.java.dao.BookDao;
import com.zhang.java.domain.Book;
import com.zhang.java.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2023/2/16 21:18
 * @Author zsy
 * @Description
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        //当前参数不为空才拼接
        queryWrapper.like(Strings.isNotEmpty(book.getType()), "type", book.getType());
        queryWrapper.like(Strings.isNotEmpty(book.getName()), "name", book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getDescription()), "description", book.getDescription());
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page, queryWrapper);
        return page;
    }
}
