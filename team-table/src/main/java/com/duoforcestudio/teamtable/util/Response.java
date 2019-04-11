package com.duoforcestudio.teamtable.util;

public class Response<T> {
    private static final int STATUS_OK = 1;
    private static final int STATUS_FAIL = 0;

    private static final String MSG_SUCCESS = "success";
    private static final String MSG_FAIL = "fail";

    private int code;

    private String msg;

    private T data;

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setCode(STATUS_OK);
        response.setMsg(MSG_SUCCESS);
        return response;
    }

    public static <T> Response<T> buildSuccess(T data) {
        Response<T> response = success();
        response.setData(data);
        return response;
    }

    public static Response buildSuccess(String message) {
        Response response = new Response();
        response.setCode(STATUS_OK);
        response.setMsg(message);
        return response;
    }

    public static Response fail() {
        Response response = new Response();
        response.setCode(STATUS_FAIL);
        response.setMsg(MSG_FAIL);
        return response;
    }

    public static Response fail(String message) {
        Response response = new Response();
        response.setCode(STATUS_FAIL);
        response.setMsg(message);
        return response;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
