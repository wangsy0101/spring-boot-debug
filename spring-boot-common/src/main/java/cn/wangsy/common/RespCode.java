package cn.wangsy.common;

/**
 * Created by wangsy on 2020/5/19
 */
public enum RespCode {


    SUCCESS(200, 60000, "OK"),
    AUTH_INVALID(200, 60001, "认证无效"),
    DECRYPT_FAIL(200, 60002, "解密失败"),
    TOKEN_REQUIRED(200, 60003, "缺少Token"),
    TOKEN_INVALID(200, 60004, "会话无效"),
    METHOD_NOT_SUPPORT(200, 60005, "请求方法不支持"),
    MEDIA_NOT_SUPPORT(200, 60006, "媒体类型不支持"),
    BODY_INVALID(200, 60007, "Body无效"),
    SERVER_ERROR(500, 60008, "服务器端出错"),
    API_NOT_FOUNT(404, 60009, "API没有找到"),
    SESSION_NOT_EFFECT(403, 64010, "session not effect"),
    SESSION_TIME_OUT(403, 64011, "session time out"),
    SESSION_VALIDATE_FAIL(403, 64012, "session validate failure"),
    PARAM_ERROR(200, 60016, "参数错误"),

    ;


    private int httpCode;
    private int code;
    private String message;


    private RespCode(int httpCode, int code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }


    public int getHttpCode() {
        return this.httpCode;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }



}
