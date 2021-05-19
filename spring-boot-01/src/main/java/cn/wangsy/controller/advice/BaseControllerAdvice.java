package cn.wangsy.controller.advice;

import cn.wangsy.common.RespCode;
import cn.wangsy.helper.HttpContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;


@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {


    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<?> unknownErrorHandler(Exception e) {
        log.error("catch unknown exception:" + e.getMessage(), e);
        return HttpContextHelper.buildResponse(RespCode.SERVER_ERROR);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.info("missingServletRequestParameterException:" + e.getMessage());
        return HttpContextHelper.buildResponse(RespCode.PARAM_ERROR);
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> bindException(BindException e) {
        log.info("bindException:" + e.getMessage());
        return HttpContextHelper.buildResponse(RespCode.BODY_INVALID);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.info("params mismatch:" + e.getMessage());
        return HttpContextHelper.buildResponse(RespCode.PARAM_ERROR);
    }

    @ExceptionHandler({MultipartException.class})
    public ResponseEntity<?> multipartExceptionHandler(MultipartException e) {
        log.warn("multipartExceptionHandler", e);
        return HttpContextHelper.buildResponse(RespCode.BODY_INVALID);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<?> methodNotSupportedHandler(Exception e) {
        log.warn("catch method not supported handler", e);
        return HttpContextHelper.buildResponse(RespCode.METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> noHandlerFoundException(Exception e) {
        log.warn("catch no handler found exception", e);
        return HttpContextHelper.buildResponse(RespCode.API_NOT_FOUNT);
    }

    @ExceptionHandler({HttpMediaTypeException.class, HttpMediaTypeNotAcceptableException.class})
    public ResponseEntity<?> httpMediaTypeErrorHandler() {
        Object body = HttpContextHelper.buildResponseBody(RespCode.MEDIA_NOT_SUPPORT);
        return new ResponseEntity<>(body, HttpStatus.valueOf(RespCode.MEDIA_NOT_SUPPORT.getHttpCode()));
    }

}
