package com.lyu.springboot.redis.spingbootredis.msg;

/**
 * @Author: Lyu
 * @Description: 返回数据
 * @Date: Created in 9:44 2020/10/13
 * @Modified By:
 */
public class BaseResponse<T> {
    /**
     * 状态码，默认200
     */
    private int status = 200;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
