package com.sample.lwj.web.utils;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 状态码枚举
 * @date 2021/8/4 18:14
 */
public enum CodeEnum {

    /*
     * 错误信息
     * */
    SUCCESS(0, "success"),
    FAIL(-1, "fail"),
    ERROR(500, "系统繁忙，请稍后重试。"),
    NO_PERMISSIONS(1000, "权限不足"),
    EXPIRED_CREDENTIALS(1001, "登陆已过期,请重新登陆");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
