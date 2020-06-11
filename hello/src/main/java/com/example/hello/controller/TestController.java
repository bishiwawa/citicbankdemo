package com.example.hello.controller;

import com.example.hello.mapper.UserMapper;
import com.example.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserService userService;

    @RequestMapping("/halo")
    public String test(Integer v1){
        System.out.println(v1);
        //Boolean tt = userService.deal("189", "789", new BigDecimal(10));
        //System.out.println(tt);
        return "/index";
    }
}
