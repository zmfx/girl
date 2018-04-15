package com.zmfx.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController   //等同于@Controller+@ResponseBody
@Controller
//@ResponseBody //向页面展示，默认解析为json格式
public class HelloController {
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;

    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String showInfo(){
        //return cupSize+age;
        //return content;
        return girlProperties.toString();
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        //return "Hello Spring Boot!";
        return "index";//在pom中加入spring-boot-starter-thymeleaf的依赖，相当于springmvc里面的视图解析
    }
}
