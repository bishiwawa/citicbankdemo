package com.example.hello.controller;

import com.example.hello.po.User;
import com.example.hello.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @Resource
    private UserService userService;

    @RequestMapping("")
    public String index(){
        System.out.println("123456");
        return "welcome";
    }

    @RequestMapping("/list")
    public Object list(Model model){
        List<User> users = userService.list();
        model.addAttribute("item",users);
        return "list";
    }


    @RequestMapping("/add")
    @ResponseBody
    public boolean add(User user){
        return userService.saveOrUpdate(user);
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Object getOne(Integer id){
        return userService.getUserById(id);
    }

}
