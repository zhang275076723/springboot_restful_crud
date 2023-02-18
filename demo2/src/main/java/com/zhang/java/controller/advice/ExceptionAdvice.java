package com.zhang.java.controller.advice;

import com.zhang.java.util.ReturnData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date 2023/2/18 19:37
 * @Author zsy
 * @Description 异常处理，返回统一的数据格式
 */
@RestControllerAdvice
public class ExceptionAdvice {
    //对Exception异常进行处理
    @ExceptionHandler(Exception.class)
    public ReturnData doOtherException(Exception ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        ex.printStackTrace();
        return new ReturnData(false, null, "系统错误，请稍后再试！");
    }
}
