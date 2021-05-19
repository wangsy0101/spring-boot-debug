package cn.wangsy.common;

import com.google.common.collect.ImmutableMap;

/**
 * Created by wangsy on 2020/5/19
 */
public class RespObject<T> {

    private int code;
    private String msg;
    private T data;




    public RespObject() {
        this.code = RespCode.SUCCESS.getCode();
        this.msg = RespCode.SUCCESS.getMessage();
    }

    public RespObject(T data) {
        this.code = RespCode.SUCCESS.getCode();
        this.msg = RespCode.SUCCESS.getMessage();
        this.data = data;
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

    public static RespObject ok() {
        return new RespObject();
    }

    public static RespObject ok(Object obj) {
        return new RespObject(obj);
    }

    public static RespObject ok(String key, Object obj) {
        return new RespObject(ImmutableMap.of(key, obj));
    }
}
