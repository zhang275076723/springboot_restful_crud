package com.zhang.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author zsy
 * @Create 2020/4/13 8:51
 * @Description
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("h", "<h1>测试</h1>");
        map.put("users", Arrays.asList("张三", "李四"));
        return "hello";
    }

}
