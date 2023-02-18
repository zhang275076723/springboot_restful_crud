package com.zhang.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2023/2/16 21:46
 * @Author zsy
 * @Description 后端数据返回给前端的统一格式数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnData {
    //是否操作成功
    private Boolean flag;
    //封装数据，用于携带数据
    private Object data;
    //封装消息，用于兼容出现异常的提示消息
    private String msg;
}
