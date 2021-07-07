package cn.wangsy.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangsy on 2021/7/2
 */
@RestController
public class StaticController {


    @RequestMapping("/1556076266459.jpg")
    public String test(){
        return "this is controller";
    }


    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }


    public static void main(String[] args) {
        System.out.println((Long.MAX_VALUE + "").length());
        System.out.println((Integer.MAX_VALUE + "").length());
        System.out.println((Integer.MAX_VALUE + ""));

    }
}
