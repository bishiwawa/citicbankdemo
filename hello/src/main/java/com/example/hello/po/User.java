package com.example.hello.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

  private String user;
  private String password;

  @TableId(value = "id",type = IdType.AUTO)
  private long id;

}
