package com.zhang.java.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhang.java.domain.Book;
import com.zhang.java.service.BookService;
import com.zhang.java.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Date 2023/2/16 21:47
 * @Author zsy
 * @Description
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ReturnData getAll() {
        return new ReturnData(true, bookService.getAll(), null);
    }

    //restful风格
    @PostMapping()
    public ReturnData save(@RequestBody Book book) throws IOException {
        //模拟异常，springmvc统一异常处理
        if ("123".equals(book.getName())) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new ReturnData(flag, flag ? "添加成功^_^" : "添加失败-_-!", null);
    }

    //restful风格
    @PutMapping()
    public ReturnData update(@RequestBody Book book) throws IOException {
        //模拟添加失败，前端提示
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = bookService.update(book);
        return new ReturnData(flag, flag ? "修改成功^_^" : "修改失败-_-!", null);
    }

    //restful风格
    @DeleteMapping("/{id}")
    public ReturnData delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new ReturnData(flag, flag ? "删除成功^_^" : "删除失败-_-!", null);
    }

    //restful风格
    @GetMapping("/{id}")
    public ReturnData getById(@PathVariable Integer id) {
        return new ReturnData(true, bookService.getById(id), null);
    }

    //分页查询，如果book中参数不为空，则为分页条件查询
    @GetMapping("/{currentPage}/{pageSize}")
    public ReturnData getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        //如果book中参数不为空，则为分页条件查询
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new ReturnData(true, page, null);
    }
}
