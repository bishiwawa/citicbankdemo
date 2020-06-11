package com.example.hello.service;

import java.math.BigDecimal;

public interface UserService {
    void deal(String cardIdSrc, String cardIdDes, BigDecimal transMoney) throws Exception;
}
