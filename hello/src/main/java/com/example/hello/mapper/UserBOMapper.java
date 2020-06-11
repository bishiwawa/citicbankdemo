package com.example.hello.mapper;

import com.example.hello.po.UserBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息查询
 *
 * @author ld
 * @date 2020.6.10
 * */
@Mapper
public interface UserBOMapper {
    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     * @return 用户信息
     * */
    UserBO getUserInfo(int userId);
}
