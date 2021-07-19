package cn.wangsy;

import cn.wangsy.config.MyConfiguration;
import cn.wangsy.config.WebConfiguration;
import cn.wangsy.entity.Account;
import cn.wangsy.entity.House;
import cn.wangsy.entity.People;
import cn.wangsy.service.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


/**
 * Created by wangsy on 2021/7/1
 */

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        // 1、@import 普通java类
        Service3 service3 = run.getBean(Service3.class);
        service3.hello();

        // 2、@import 配置类（配置类不用写 @Configuration 注解）
        Service6 service6 = run.getBean(Service6.class);
        service6.hello();

        // 3、@import ImportSelector 接口实现类
        Service4A service4A = run.getBean(Service4A.class);
        service4A.hello();
        Service4B service4B = run.getBean(Service4B.class);
        service4B.hello();

        // 4、@import ImportBeanDefinitionRegistrar 接口实现类
        Service5A service5A = run.getBean(Service5A.class);
        service5A.hello();
        Service5B service5B = run.getBean(Service5B.class);
        service5B.hello();




//        Account account1 = run.getBean("account", Account.class);
//        Account account2 = run.getBean("account", Account.class);
//
////         直接 getBean 是从 IOC 容器中获取，默认是单例，所以多次获取都是相同的bean
//        System.out.println("result1: " + (account1 == account2));  // true
////         @Configuration(proxyBeanMethods = true) // 使用代理，直接从IOC容器之中取得对象
//        MyConfiguration myConfiguration = run.getBean("myConfiguration", MyConfiguration.class);
//        System.out.println("result2: " + myConfiguration);
//        System.out.println("result3: " + (myConfiguration.getPerson() == myConfiguration.getPerson()));
//        System.out.println("result4: " + (myConfiguration.getPerson().getAccount() == myConfiguration.getAccount()));


//        boolean person = run.containsBean("person");
//        System.out.println(person);
//
//        boolean account = run.containsBean("account");
//        System.out.println(account);

//        House house = run.getBean(House.class);
//        System.out.println(JSON.toJSONString(house));


    }
}
