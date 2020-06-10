package com.example.hello.mapper;

import com.example.hello.po.UserBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 卡片相关mapper
 *
 * @author ld
 * @date 2020.6.10
 * */
@Mapper
public interface CardBOMapper {
    /**
     * 开卡
     * */
    int openCard(UserBO userBO);

    /**
     * 销卡
     * */
    int cancelCard(int userId);
}
