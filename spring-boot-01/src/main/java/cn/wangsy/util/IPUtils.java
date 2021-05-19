package cn.wangsy.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangsy on 2020/5/19
 */
public class IPUtils {

    /**
     * 获取请求的客户端的 IP 地址。若应用服务器前端配有反向代理的 Web 服务器，
     * 需要在 Web 服务器中将客户端原始请求的 IP 地址加入到 HTTP header 中。
     * 详见 {@link #PROXY_REMOTE_IP_ADDRESS}
     */
    public static String getRemoteIp(HttpServletRequest request ) {
        for (String key : PROXY_REMOTE_IP_ADDRESS) {
            String ip = request.getHeader(key);
            if (ip != null && ip.trim().length() > 0) {
                return getRemoteIpFromForward(ip.trim());
            }
        }
        return request.getRemoteHost();
    }

    /**
     * Web 服务器反向代理中用于存放客户端原始 IP 地址的 Http header 名字，
     * 若新增其他的需要增加或者修改其中的值。
     */
    private static final String[] PROXY_REMOTE_IP_ADDRESS = { "X-Forwarded-For", "X-Real-IP" };

    /**
     * 从 HTTP Header 中截取客户端连接 IP 地址。如果经过多次反向代理，
     * 在请求头中获得的是以“,”分隔 IP 地址链，第一段为客户端 IP 地址。
     * @param xForwardIp 从 HTTP 请求头中获取转发过来的 IP 地址链
     * @return 客户端源 IP 地址
     */
    private static String getRemoteIpFromForward(String xForwardIp) {
        int commaOffset = xForwardIp.indexOf(',');
        if (commaOffset < 0) {
            return xForwardIp;
        }
        return xForwardIp.substring(0 , commaOffset);
    }


}
