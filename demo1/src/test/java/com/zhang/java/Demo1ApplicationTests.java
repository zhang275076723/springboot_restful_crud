package com.zhang.java;

import com.zhang.java.dao.DepartmentDao;
import com.zhang.java.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

@SpringBootTest
//指定使用的配置类
@ContextConfiguration(classes = Demo1Application.class)
class Demo1ApplicationTests {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    void test() {
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
    }
}
