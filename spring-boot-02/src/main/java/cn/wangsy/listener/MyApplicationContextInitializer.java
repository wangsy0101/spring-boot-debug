package cn.wangsy.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by wangsy on 2021/7/13
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("====== " + this.getClass().getSimpleName() + " ==== initialize");
    }
}
