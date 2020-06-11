package com.example.hello.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 银行相关前端展示类
 *
 * @author ld
 * @date 2020.6.11
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardVO {
    private Integer code;
    private String msg;
}
