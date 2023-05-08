package com.imooc.springbootlearn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取配置类
 */
@RestController
public class ConfigController {

    @Autowired
    SchoolConfig schoolConfig;

    @GetMapping("/fromconfig")
    public String gradeClass(){
        return "年级："+schoolConfig.grade+" 班级："+schoolConfig.classnum;
    }
}
