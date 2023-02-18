package com.zhang.java.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.java.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date 2023/2/11 22:43
 * @Author zsy
 * @Description
 */
//不使用@Mapper，在mp配置类中使用@MapperScan
public interface BookDao extends BaseMapper<Book> {

}
