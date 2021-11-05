package cn.wangsy.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by wangsy on 2021/11/5
 */
@Service
public class PublishSenderB {

    @Autowired
    private ApplicationContext applicationContext;



    public void publishSender(){
        PublishBeanB bean = new PublishBeanB();
        bean.setWord1(345);
        bean.setWord2("呵呵");
        applicationContext.publishEvent(new PublishEventB(bean));
    }
}
