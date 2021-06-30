package cn.wangsy.controller.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by wangsy on 2020/5/19
 */
@Component
@Aspect
public class LogAspect {


    @Around("execution(* cn.wangsy.controller.*Controller.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间

        Object[] args = pjp.getArgs();
        Object result = null;
        Exception e = null;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = (HttpServletRequest) sra.getRequest();
        try {
            result = pjp.proceed(); // result的值就是被拦截方法的返回值
            return result;
        } catch (Exception re) {
            e = re;
            throw re;
        } finally {
            if (args != null) {
                args = Arrays.stream(args).filter(a -> !(a instanceof HttpServletRequest || a instanceof HttpServletResponse)).toArray();
            } else {
                args = new String[0];
            }
            String response = e == null ? JSON.toJSONString(result) : e.getMessage();

            long endTimeMillis = System.currentTimeMillis();
            Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());

//            log.info("method:{}, ip={}, args={}, response={}, cost {} ms",
//                    request.getServletPath(),
//                    request.getAttribute("ip"),
//                    args,
//                    response, (endTimeMillis - startTimeMillis));
        }
    }


}
