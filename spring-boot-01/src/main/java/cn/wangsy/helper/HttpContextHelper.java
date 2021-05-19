package cn.wangsy.helper;

import cn.wangsy.common.RespCode;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsy on 2020/5/19
 */
@Slf4j
public class HttpContextHelper {


    public static Object buildResponseBody(int code, String message, Object extra) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("msg", message);
        if (extra != null) {
            body.put("data", extra);
        }
        return body;
    }


    public static Object buildResponseBody(int code, String message, String title, Integer exCode, Object extra) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("msg", message);
        body.put("title",title);
        body.put("exCode", exCode);
        if (extra != null) {
            body.put("data", extra);
        }
        return body;
    }


    public static Object buildResponseBody(RespCode errorCode) {
        return JSON.toJSONString(buildResponseBody(errorCode.getCode(), errorCode.getMessage(), null));
    }

    public static Object buildResponseBody(RespCode errorCode, Object extra) {
        return buildResponseBody(errorCode.getCode(), errorCode.getMessage(), extra);
    }

    public static ResponseEntity<?> buildResponse(int httpCode, int code, String message, Object extra) {
        return buildResponse(httpCode, buildResponseBody(code, message, extra));
    }

    public static ResponseEntity<?> buildResponse(int httpCode, int code, String message, String title, Integer exCode, Object extra) {
        return buildResponse(httpCode, buildResponseBody(code, message, title, exCode, extra));
    }

    public static ResponseEntity<?> buildResponse(int httpCode, Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        log.info("Response: httpCode:{}, body:{}", httpCode, JSON.toJSONString(body));
        return new ResponseEntity<>(body, headers, HttpStatus.valueOf(httpCode));
    }

    public static ResponseEntity<?> buildResponse(int httpCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        log.info("Response: httpCode:{}", httpCode);
        return new ResponseEntity<>(headers, HttpStatus.valueOf(httpCode));
    }

    public static ResponseEntity<?> buildResponse(RespCode errorCode) {
        return buildResponse(errorCode.getHttpCode(), errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static ResponseEntity<?> buildResponse(RespCode errorCode, Object extra) {
        return buildResponse(errorCode.getHttpCode(), errorCode.getCode(), errorCode.getMessage(), extra);
    }

    public static void response(HttpServletResponse response, RespCode errorCode) throws IOException {
        log.info("Response: {}", errorCode);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(errorCode.getHttpCode());
        response.getWriter().print(buildResponseBody(errorCode));
    }




}
