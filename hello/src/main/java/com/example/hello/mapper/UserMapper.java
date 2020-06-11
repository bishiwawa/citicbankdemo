package com.example.hello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //List<User> getAllUser(Integer id);
    //通过卡号查的余额
    BigDecimal getBalanceByCardId(String cardId);
    //通过卡号更新余额
    int updateBalanceByCardId(@Param("cardId")String cardId,
                              @Param("newBalance")BigDecimal newBalance);
    //查询银行卡是否存在
    int existByCardId(String cardId);
    //减钱
    int reduceBalanceByCardId(@Param("cardId")String cardId,
                              @Param("money")BigDecimal money);
    //加钱
    int addBalanceByCardId(@Param("cardId")String cardId,
                              @Param("money")BigDecimal money);
}
