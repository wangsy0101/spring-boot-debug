package cn.wangsy.controller.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangsy on 2021/11/10
 */
@Aspect
@Slf4j
@Component
public class MyAnnotationAspect {


    @Pointcut("@annotation(cn.wangsy.annotation.MyAnnotation)")
    public void myAnnotationPointcut(){

    }

    @Around(value = "myAnnotationPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 判断逻辑...
        Object result = joinPoint.proceed();
        log.info("{}", JSON.toJSONString(result));
        return result;
    }


}
