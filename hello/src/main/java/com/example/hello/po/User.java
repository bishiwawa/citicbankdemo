package com.example.hello.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
  @TableId
  private int user_id;

  private String card_id;
  private String password;
  private String username;
  private boolean gender;
  private String id_card;
  private BigDecimal balance;
}
