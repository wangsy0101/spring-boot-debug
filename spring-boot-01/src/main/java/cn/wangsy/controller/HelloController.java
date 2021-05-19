package cn.wangsy.controller;

import cn.wangsy.common.RespCode;
import cn.wangsy.common.RespObject;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class HelloController {


    @RequestMapping(value = "/v1/hello", method = RequestMethod.GET)
    public String v1(@RequestParam("a") String a) {
        return "hello world";
    }


    @RequestMapping(value = "/v2/hello", method = RequestMethod.GET)
    public RespObject v2(@RequestParam("a") String a) {
        Map map = new HashMap();
        map.put("11", "中国");
        return RespObject.ok("result", map);
    }


}
