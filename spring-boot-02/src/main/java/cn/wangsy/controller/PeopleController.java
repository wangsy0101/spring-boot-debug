package cn.wangsy.controller;

import cn.wangsy.entity.House;
import cn.wangsy.entity.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangsy on 2021/7/6
 */
@RestController
public class PeopleController {


    /**
     * 自定义类型解析器
     * @return
     */
    @GetMapping("/v1/people")
    public People queryPeople(){
        People people = new People();
        people.setAge(18);
        people.setName("wangsy");
        return people;
    }
}
