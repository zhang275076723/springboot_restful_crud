package com.zhang.java;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.java.dao.BookDao;
import com.zhang.java.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Date 2023/2/11 22:57
 * @Author zsy
 * @Description
 */
@SpringBootTest
//指定使用的配置类
@ContextConfiguration(classes = Demo2Application.class)
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        int count = bookDao.insert(book);
        System.out.println("插入影响的行数：" + count);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(17);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        int count = bookDao.updateById(book);
        System.out.println("更新影响的行数：" + count);
    }

    @Test
    public void testDelete() {
        int count = bookDao.deleteById(16);
        System.out.println("删除影响的行数：" + count);
    }

    @Test
    public void testGetAll() {
        //全部查询
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }

    @Test
    public void tesPage() {
        //当前页，每页大小
        Page<Book> page = new Page<>(2, 4);
        //分页之后要紧跟查询语句
        bookDao.selectPage(page, null);

        //当前页数据的list集合
        System.out.println(page.getRecords());
        //当前页
        System.out.println(page.getCurrent());
        //总页数
        System.out.println(page.getPages());
        //当前显示条数
        System.out.println(page.getSize());
        //查询的总记录数
        System.out.println(page.getTotal());
        //当前页是否有下一页
        System.out.println(page.hasNext());
        //当前页是否有上一页
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testSelectQuery() {
        //条件查询，QueryWrapper封装条件查询对象
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Spring");
        List<Book> users = bookDao.selectList(queryWrapper);
        System.out.println(users);

        //建议使用LambdaQueryWrapper
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //避免了"name"输入错误
        lambdaQueryWrapper.like(Book::getName, "Spring");
        List<Book> users2 = bookDao.selectList(lambdaQueryWrapper);
        System.out.println(users2);
    }
}
