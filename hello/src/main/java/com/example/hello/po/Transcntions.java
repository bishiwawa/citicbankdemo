package com.example.hello.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("transactions")
public class Transcntions {
    @TableId
    private long tran_id;

    private boolean tran_type;
    private String card_id1;
    private String card_id2;
    private BigDecimal money;
    private Timestamp time;
}
