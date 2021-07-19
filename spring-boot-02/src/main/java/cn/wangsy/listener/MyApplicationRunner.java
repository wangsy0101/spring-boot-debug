package cn.wangsy.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by wangsy on 2021/7/13
 */

@Component
@Order(2)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("====== " + this.getClass().getSimpleName() + " ==== run");
    }
}
