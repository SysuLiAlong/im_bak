package com.lialong.im;

import org.springframework.util.StringUtils;

public class AjaxResult<T> {
    private int code;
    private T data;
    private String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> AjaxResult success(T data) {
        AjaxResult<T> ajaxResult = new AjaxResult<>();
        ajaxResult.setCode(ResponseCode.SUCCESS.getCode());
        ajaxResult.setData(data);
        return ajaxResult;
    }

    public static <T> AjaxResult fail(String msg) {
        AjaxResult<T> ajaxResult = new AjaxResult<>();
        ajaxResult.setCode(ResponseCode.FAIL.getCode());
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }

}
