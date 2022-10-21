package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Auther Terence Zhang
 * @Datetime 2022/10/21 14:39
 **/
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @PostMapping("upload")
    public R<String> upload(MultipartFile file){
        log.info(file.toString());
        return R.success("文件上传成功");
    }
}
