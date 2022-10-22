package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Description 全局异常处理
 * @Auther Terence Zhang
 * @Datetime 22/10/15 21:42
 **/
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @name exceptionHandler
     * @description
     * @author Sora
     * @param:
     * @DateTime 22/10/15 22:17
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在";
            return R.error(msg);
        }
        return R.error("失败了:(");
    }


    /**
     * @name exceptionHandler
     * @description 处理自定义异常
     * @author Sora
     * @param:
     * @DateTime 22/10/20 22:26
     * @return:
     * @throws
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public R<String> exceptionHandler(IOException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

}


