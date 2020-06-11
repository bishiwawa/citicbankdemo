package com.example.hello.service.impl;

import com.example.hello.mapper.TransactionsMapper;
import com.example.hello.mapper.UserMapper;
import com.example.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionsMapper transactionsMapper;

    @Transactional
    public void deal (String cardIdSrc, String cardIdDes, BigDecimal transMoney) throws Exception{
        userMapper.reduceBalanceByCardId(cardIdSrc, transMoney);
        userMapper.addBalanceByCardId(cardIdDes, transMoney);
        //throw new RuntimeException("伪造的异常");    //伪造异常，测试回滚操作
    }
}
