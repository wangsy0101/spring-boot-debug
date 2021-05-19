package cn.wangsy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wangsy on 2020/5/19
 */
@SpringBootApplication
@Slf4j
@MapperScan(basePackages="cn.wangsy.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
