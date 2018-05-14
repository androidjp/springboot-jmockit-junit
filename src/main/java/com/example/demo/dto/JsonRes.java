package com.example.demo.dto;

import java.io.Serializable;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:37
 * Description:
 */
public class JsonRes {
    private int code;
    private String message;
    private Object data;

    public JsonRes(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonRes() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonRes{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
