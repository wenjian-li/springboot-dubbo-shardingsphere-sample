package com.sample.lwj.exception;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 自定义业务异常
 * @date 2021/8/9 17:52
 */
public class BizException extends RuntimeException {
    /**
     * 异常code
     */
    private int code = 500;
    /**
     * 异常提示信息
     */
    private String msg;


    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BizException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BizException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
