package com.example.hello.service;

import com.example.hello.po.Status;

/**
 * “”开卡销卡服务接口
 *
 * @author ld
 * @date 2020.6.10
 * */
public interface ICardService {
    /**
     * 开卡
     *
     * @param userId 用户Id
     * @return 结果
     * */
    Status openCard(int userId);

    /**
     * 销卡
     *
     * @param userId 用户id
     * @return 结果
     * */
    Status cancelCard(int userId);
}
