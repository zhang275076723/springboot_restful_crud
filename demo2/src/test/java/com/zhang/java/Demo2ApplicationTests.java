package com.zhang.java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
//指定使用的配置类
@ContextConfiguration(classes = Demo2Application.class)
class Demo2ApplicationTests {

    @Test
    void contextLoads() {
    }

}
