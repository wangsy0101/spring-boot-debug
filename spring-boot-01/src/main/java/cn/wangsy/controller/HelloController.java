package cn.wangsy.controller;

import cn.wangsy.annotation.MyAnnotation;
import cn.wangsy.common.RespObject;
import cn.wangsy.controller.event.PublishSenderA;
import cn.wangsy.controller.event.PublishSenderB;
import cn.wangsy.service.RateLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
@Slf4j
public class HelloController {


    @Autowired
    private RateLimitService rateLimitService;

    @Autowired
    private PublishSenderA publishSenderA;

    @Autowired
    private PublishSenderB publishSenderB;

    @RequestMapping(value = "/v1/hello", method = RequestMethod.GET)
    @MyAnnotation
    public String v1(@RequestParam("a") String a) {
        publishSenderA.publishSender();
        if (rateLimitService.tryAcquire()) {
            return "hello world";
        }else {
            return "hello world";
        }

    }


    @RequestMapping(value = "/v2/hello", method = RequestMethod.GET)
    public RespObject v2(@RequestParam("a") String a) {
        publishSenderB.publishSender();
        Map map = new HashMap();
        map.put("11", "中国");
        return RespObject.ok("result", map);
    }


}
