package com.itheima.reggie.common;

/**
 * @Description 自定义业务异常类
 * @Auther Terence Zhang
 * @Datetime 22/10/20 22:23
 **/
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
