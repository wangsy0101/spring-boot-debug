package cn.wangsy.endpoints.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by wangsy on 2021/7/8
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        System.out.println("===== doHealthCheck ======");
        if (true){
            builder.up();
        }else {
            builder.outOfService();
        }
        builder.withDetail("msg", "aaa");
    }

}
