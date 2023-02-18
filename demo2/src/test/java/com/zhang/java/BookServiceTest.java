package com.zhang.java;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.java.domain.Book;
import com.zhang.java.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Date 2023/2/16 21:22
 * @Author zsy
 * @Description
 */
@SpringBootTest
//指定使用的配置类
@ContextConfiguration(classes = Demo2Application.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

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
        Boolean flag = bookService.save(book);
        System.out.println("添加数据：" + flag);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(51);
        book.setType("测试数据666");
        book.setName("测试数据666");
        book.setDescription("测试数据666");
        bookService.update(book);
    }

    @Test
    void testDelete() {
        Boolean flag = bookService.delete(53);
        System.out.println("删除：" + flag);
    }

    @Test
    void testGetAll() {
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }

    @Test
    void testGetPage() {
        //分页查询
        IPage<Book> page = bookService.getPage(2, 5);
        //当前页
        System.out.println(page.getCurrent());
        //当前页大小
        System.out.println(page.getSize());
        //查询总记录数
        System.out.println(page.getTotal());
        //总页数
        System.out.println(page.getPages());
        //当前页数据的list集合
        System.out.println(page.getRecords());

        System.out.println("-------------------------");

        //条件查询
        Book book = new Book();
        book.setName("s");
        IPage<Book> page2 = bookService.getPage(2, 3, book);
        //当前页
        System.out.println(page2.getCurrent());
        //当前页大小
        System.out.println(page2.getSize());
        //查询总记录数
        System.out.println(page2.getTotal());
        //总页数
        System.out.println(page2.getPages());
        //当前页数据的list集合
        System.out.println(page2.getRecords());
    }
}
