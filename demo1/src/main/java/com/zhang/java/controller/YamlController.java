package com.zhang.java.controller;

import com.zhang.java.domain.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/1/9 22:27
 * @Author zsy
 * @Description yaml数据读取
 */
@RestController
public class YamlController {
    //yml读取单一数据
    @Value("${person.age}")
    private int age;

    //yml读取包含引用的数据
    @Value("${center.dataDir}")
    private String dataDir;

    //yml读取全部数据
    @Autowired
    private Environment environment;

    //yml读取对象数据
    @Autowired
    private DataSource dataSource;

    @GetMapping("/testYaml")
    public String testYaml() {
        System.out.println(dataDir);
        System.out.println(dataSource.toString());
        return "age:" + age + ",name:" + environment.getProperty("person.name") +
                ",lessons:" + environment.getProperty("person.lessons[2]");
    }
}
