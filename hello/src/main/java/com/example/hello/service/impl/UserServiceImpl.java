package com.example.hello.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.mapper.UserMapper;
import com.example.hello.po.User;
import com.example.hello.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;

    private List<User> getAllUser(Integer id){
        return userMapper.getAllUser(id);
    }

    @Override
    public User getUserById(Integer id){
        List<User> users = getAllUser(id);
        if(users == null || users.size() == 0){
            return null;
        }
        return users.get(0);
    }


}
