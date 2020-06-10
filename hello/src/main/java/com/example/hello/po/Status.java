package com.example.hello.po;

/**
 * 接口状态
 *
 * @author ld
 * @date 2020.6.10
 * */
public enum Status {
    OK("成功", 1),
    VALIDATE_ERROR("验证失败", 2),
    NO_AUTHORITY("权限不足",3),
    SERVER_ERROR("服务器异常",4),
    CANCEL_CARD_ERROR("注销银行卡失败",5);

    private String des;
    private int code;

    Status(String des, int code) {
        this.des = des;
        this.code = code;
    }
}
