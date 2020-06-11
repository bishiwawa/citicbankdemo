package com.example.hello.po;

import lombok.*;

/**
 * 用户信息业务类
 *
 * @author ld
 * @date 2020.6.10
 * */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBO {
    //用户Id
    private Integer userId;
    //用户卡Id
    private String cardId;
    //用户持卡Id
    private String idCard;
}
