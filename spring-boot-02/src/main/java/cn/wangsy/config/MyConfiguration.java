package cn.wangsy.config;

import cn.wangsy.entity.Account;
import cn.wangsy.entity.House;
import cn.wangsy.entity.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangsy on 2021/7/1
 */
//@Configuration(proxyBeanMethods = false)
@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties(House.class)
public class MyConfiguration {



    @Bean("account")
    public Account getAccount(){
        Account account = new Account();
        account.setName("小明的账户");
        return account;
    }


    // 顺序！！！ 注解 @ConditionalOnBean 生效，需要保证 bean: account 优先于 person 注入
    @Bean("person")
    @ConditionalOnBean(name = "account")
    public Person getPerson(){
        Person person = new Person();
        person.setName("小明");
        person.setAccount(getAccount());
        return person;
    }





}



