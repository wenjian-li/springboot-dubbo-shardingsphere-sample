package com.sample.lwj.web.exception;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 自定义异常
 * @date 2021/8/9 17:52
 */
public class AppException extends RuntimeException {
    private String msg;
    private int code = 500;

    public AppException() {
    }

    public AppException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AppException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
