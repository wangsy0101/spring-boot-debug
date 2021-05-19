package cn.wangsy.interceptors;

import cn.wangsy.common.RespCode;
import cn.wangsy.helper.HttpContextHelper;
import cn.wangsy.util.IPUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;
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
        String userAgent = request.getHeader("User-Agent");
        String accept = request.getHeader("Accept");

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
}
