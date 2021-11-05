package cn.wangsy.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by wangsy on 2021/11/5
 */
@Service
public class PublishSenderA {

    @Autowired
    private ApplicationContext applicationContext;



    public void publishSender(){
        PublishBeanA bean = new PublishBeanA();
        bean.setId(123);
        bean.setName("哈哈");
        applicationContext.publishEvent(new PublishEventA(bean));
    }
}
