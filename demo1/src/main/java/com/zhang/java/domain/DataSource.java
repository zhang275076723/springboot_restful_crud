package com.zhang.java.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Date 2023/1/9 22:48
 * @Author zsy
 * @Description
 */
//@ConfigurationProperties绑定配置信息到封装类中
@ConfigurationProperties(prefix = "datasource")
@Component
@Data
public class DataSource {
    //与yml中名字驼峰命名相对应
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
