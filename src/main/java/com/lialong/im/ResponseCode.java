package com.lialong.im;

public enum ResponseCode {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    PARAM_ERR(-3, "参数错误"),
    FAIL_AUTH(-4, "未认证"),
    AUTH_NAME_OR_PASSWORD_WRONG(1013, "手机号或者密码错误"),
    AUTH_LOGIN_BLACK_LIST(1014, "用户无法访问");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
