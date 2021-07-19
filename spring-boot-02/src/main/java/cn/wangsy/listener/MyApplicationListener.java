package cn.wangsy.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by wangsy on 2021/7/13
 */
public class MyApplicationListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("====== " + this.getClass().getSimpleName() + " ===== onApplicationEvent");
    }
}
