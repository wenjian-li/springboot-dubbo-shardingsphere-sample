package com.sample.lwj.remote.enums;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 用户状态枚举类
 * @date 2023-4-3 18:26:02
 */
public enum UserStatusEnum {
    /**
     * 启用
     */
    ENABLE(0, "启用"),
    /**
     * 禁用
     */
    DISABLE(1, "禁用");

    private Integer code;
    private String msg;

    UserStatusEnum(Integer code, String msg) {
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
