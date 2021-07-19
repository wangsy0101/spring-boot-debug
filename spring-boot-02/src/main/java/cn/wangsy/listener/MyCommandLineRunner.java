package cn.wangsy.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by wangsy on 2021/7/13
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====== " + this.getClass().getSimpleName() + " ==== run");
    }
}
