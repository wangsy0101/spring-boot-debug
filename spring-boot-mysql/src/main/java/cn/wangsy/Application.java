package cn.wangsy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by wangsy on 2021/7/27
 */
@SpringBootApplication
@Slf4j
@MapperScan(basePackages="cn.wangsy.dao")
@EnableHystrix
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
