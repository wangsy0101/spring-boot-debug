package cn.wangsy.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by wangsy on 2021/7/13
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication springApplication;
    private String[] args;

    public MySpringApplicationRunListener(SpringApplication springApplication, String[] args){
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("===== " + this.getClass().getSimpleName() + " === starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("===== " + this.getClass().getSimpleName() + " === environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("===== " + this.getClass().getSimpleName() + " === contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("===== " + this.getClass().getSimpleName() + " === contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("=====" + this.getClass().getSimpleName() + " === started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("===== " + this.getClass().getSimpleName() + " === running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("===== " + this.getClass().getSimpleName() + " === failed");
    }
}
