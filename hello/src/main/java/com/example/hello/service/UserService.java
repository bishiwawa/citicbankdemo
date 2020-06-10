package com.example.hello.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hello.po.User;

public interface UserService extends IService<User> {

    User getUserById(Integer id);

}
