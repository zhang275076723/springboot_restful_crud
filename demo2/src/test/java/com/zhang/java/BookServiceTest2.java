package com.zhang.java;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.java.domain.Book;
import com.zhang.java.service.BookService2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Date 2023/2/16 21:42
 * @Author zsy
 * @Description mp业务层测试，不推荐使用
 */
@SpringBootTest
//指定使用的配置类
@ContextConfiguration(classes = Demo2Application.class)
public class BookServiceTest2 {
    @Autowired
    private BookService2 bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        boolean flag = bookService.saveBook(book);
        System.out.println("添加数据：" + flag);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(52);
        book.setType("-----------------");
        book.setName("测试数据666");
        book.setDescription("测试数据666");
        bookService.modify(book);
    }

    @Test
    void testDelete() {
        boolean flag = bookService.delete(18);
        System.out.println("删除：" + flag);
    }

    @Test
    void testGetAll() {
        List<Book> books = bookService.list();
        System.out.println(books);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        //当前页
        System.out.println(page.getCurrent());
        //当前页数据量
        System.out.println(page.getSize());
        //查询总记录数
        System.out.println(page.getTotal());
        //总页数
        System.out.println(page.getPages());
        //当前页数据的list集合
        System.out.println(page.getRecords());
    }
}
