package com.zhang.java.domain;

import lombok.Data;

/**
 * @Date 2023/2/11 22:35
 * @Author zsy
 * @Description
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
