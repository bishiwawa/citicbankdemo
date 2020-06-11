package com.example.hello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.po.Transactions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface TransactionsMapper extends BaseMapper<Transactions> {
    //更新转账记录
    int updateTransRecord(@Param("cardIdSrc") String cardIdSrc,
                          @Param("cardIdDes") String cardIdDes,
                          @Param("money") BigDecimal money);
}
