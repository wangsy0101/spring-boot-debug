package cn.wangsy.interceptors;

import cn.wangsy.common.RespCode;
import cn.wangsy.helper.HttpContextHelper;
import cn.wangsy.util.IPUtils;
import cn.wangsy.util.ThreadLocalUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangsy on 2020/5/19
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(this.getClass().getSimpleName() + "==== preHandle");
        String userAgent = request.getHeader("User-Agent");
        String accept = request.getHeader("Accept");

        Integer a = Integer.valueOf(request.getHeader("a"));
        String b = request.getHeader("b");

        ThreadLocalUtils.set1Ab(a, b);

        String ip = IPUtils.getRemoteIp(request);
        request.setAttribute("ip", ip);

        if (StringUtils.isNotBlank(accept)) {
            if (!accept.contains("/")) {
                Object body = HttpContextHelper.buildResponseBody(RespCode.MEDIA_NOT_SUPPORT);
                response.setStatus(RespCode.MEDIA_NOT_SUPPORT.getHttpCode());
                response.getWriter().print(body);
                return false;
            }
        }

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("======= a: " + ThreadLocalUtils.getA());
        System.out.println("======= b: " + ThreadLocalUtils.getB());

        ThreadLocalUtils.removeAb();

        System.out.println("======= a: " + ThreadLocalUtils.getA());
        System.out.println("======= b: " + ThreadLocalUtils.getB());

        System.out.println(this.getClass().getSimpleName() + "==== afterCompletion");
    }
}
