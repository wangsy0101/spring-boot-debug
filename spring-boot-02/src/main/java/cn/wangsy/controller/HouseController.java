package cn.wangsy.controller;

import cn.wangsy.entity.House;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangsy on 2021/7/1
 */
@RestController
public class HouseController {

    @Autowired
    private House house;

    @GetMapping("/v1/house")
    public String queryHouse(@RequestParam(value = "a", required = false) String a){
        return JSON.toJSONString(house);
    }

    @PostMapping("/v1/house")
    public String postHouse(){
        return JSON.toJSONString(house);
    }


    // 矩阵变量，需要手动开启
    // 语法： /v2/house;a=q/room;a=1;b=1;b=2;b=3
    @GetMapping("/v2/{house}/{room}")
    public String v2House(@MatrixVariable(value = "a", pathVar = "house") String a1,
                          @MatrixVariable(value = "a", pathVar = "room") String a2,
                          @MatrixVariable(value = "b", pathVar = "room") List<String> blist,
                          @PathVariable("house") String house,
                          @PathVariable("room") String room){
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(JSON.toJSONString(blist));
        System.out.println(house);
        System.out.println(room);
        return JSON.toJSONString(house);
    }



}
