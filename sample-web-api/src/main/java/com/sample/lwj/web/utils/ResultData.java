package com.sample.lwj.web.utils;

import java.io.Serializable;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 返回数据
 * @date 2021/8/3 8:45
 */
public class ResultData<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 对象信息
     */
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultData() {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
    }

    /**
     * 成功提示
     *
     * @return 成功提示
     */
    public static ResultData success() {
        return new ResultData();
    }

    /**
     * 成功提示（带返回数据）
     *
     * @param data 返回数据
     * @param <T>  泛型返回值
     * @return
     */
    public static <T> ResultData success(T data) {
        return result(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 异常提示
     *
     * @return 异常提示
     */
    public static ResultData error() {
        return result(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMsg(), null);
    }

    /**
     * 异常提示
     *
     * @return 异常提示
     */
    public static ResultData error(String msg) {
        return result(CodeEnum.ERROR.getCode(), msg, null);
    }


    /**
     * 失败提示
     *
     * @param <T>  泛型返回值
     * @return
     */
    public static <T> ResultData failure(String msg) {
        return result(CodeEnum.FAIL.getCode(), msg, null);
    }


    /**
     * 失败提示（带返回数据）
     *
     * @param code 状态码
     * @param <T>  泛型返回值
     * @return
     */
    public static <T> ResultData failure(Integer code, String msg) {
        return result(code, msg, null);
    }

    /**
     * 失败提示（带返回数据）
     *
     * @param code 状态码
     * @param data 返回数据
     * @param <T>  泛型返回值
     * @return
     */
    public static <T> ResultData failure(Integer code, String msg, T data) {
        return result(code, msg, data);
    }

    /**
     * 返回提示（自定义组合）
     *
     * @param code 状态码
     * @param msg  提示信息
     * @param data 返回数据
     * @param <T>  泛型返回值
     * @return
     */
    public static <T> ResultData result(Integer code, String msg, T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.code = code;
        resultData.msg = msg;
        resultData.data = data;
        return resultData;
    }


}
