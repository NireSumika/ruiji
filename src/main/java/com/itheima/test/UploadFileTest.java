package com.itheima.test;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Auther Terence Zhang
 * @Datetime 22/10/22 9:15
 **/
public class UploadFileTest {
    @Test
    public void test1(){
        String fileName = "erersf.jpg";
        String substring = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(substring);
    }
}
