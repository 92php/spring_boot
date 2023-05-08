package com.imooc.springbootlearn;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示读取配置
 */
@RestController
public class PropertiesController {

    @Value("${school.grade}")
    Integer grade;
    @Value("${school.classnum}")
    Integer classnum;

    @GetMapping("/gradeclass")
    public String gradeClass(){
        return "年级："+grade+" 班级："+classnum;
    }
}
