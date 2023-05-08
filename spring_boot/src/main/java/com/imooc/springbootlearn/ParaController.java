package com.imooc.springbootlearn;

import org.springframework.web.bind.annotation.*;

/**
 * 演示各种传参形式
 */
@RestController
@RequestMapping("/prefix")
public class ParaController {

    @GetMapping({"/first"})
    public String firstRequest(){
        return "第一个spring boot接口";
    }

    @GetMapping({"/second"})
    public String requestPara(@RequestParam Integer num){
        return "param from request:" + num;
    }

    @GetMapping({"/three/{num}"})
    public String pathPara(@PathVariable Integer num){
        return "param from path:" + num;
    }

    @GetMapping({"/multiurl1","/multiurl2"})
    public String multiurl(@RequestParam Integer num){
        return "param from multiurl:" + num;
    }


    @GetMapping({"/required"})
    public String required(@RequestParam(required = false,defaultValue = "0") Integer num){
        return "param from required:" + num;
    }
}
