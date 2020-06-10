package com.example.hello.service.impl;

import com.example.hello.mapper.CardBOMapper;
import com.example.hello.mapper.UserBOMapper;
import com.example.hello.po.Status;
import com.example.hello.po.UserBO;
import com.example.hello.service.ICardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 开卡服务接口实现
 *
 * @author ld
 * @date 2020.6.10
 * */
@Service
public class CardServiceImpl implements ICardService {
    @Resource
    private UserBOMapper userBOMapper;
    @Resource
    private CardBOMapper cardBOMapper;

    /**
     * 业务规定开卡只能普通用户身份开卡
     * */
    @Override
    public Status openCard(int userId) {
        try{
            //查询用户信息
            UserBO userInfo = userBOMapper.getUserInfo(userId);
            if(null == userInfo || userInfo.getRole() != 0){
                return Status.NO_AUTHORITY;
            }
            //生成cardId
            String cardId = UUID.randomUUID().toString()
                    .replace("-", "")
                    .toUpperCase()
                    .substring(0,19);
            //开卡
            UserBO userBO =UserBO.builder()
                    .userId(userId)
                    .cardId(cardId)
                    .build();
            int updateRows = cardBOMapper.openCard(userBO);
            if(updateRows == 0){
                return Status.SERVER_ERROR;
            }
            return Status.OK;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return Status.SERVER_ERROR;
        }
    }

    @Override
    public Status cancelCard(int userId) {
        try{
            //查询用户信息
            UserBO userInfo = userBOMapper.getUserInfo(userId);
            if(null == userInfo || userInfo.getRole() != 0){
                return Status.NO_AUTHORITY;
            }
            int updateRows = cardBOMapper.cancelCard(userId);
            if(updateRows == 0){
                return Status.CANCEL_CARD_ERROR;
            }
            return Status.OK;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return Status.SERVER_ERROR;
        }
    }
}
