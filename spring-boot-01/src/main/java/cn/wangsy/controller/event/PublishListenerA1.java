package cn.wangsy.controller.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by wangsy on 2021/11/5
 */
@Slf4j
@Service
public class PublishListenerA1 implements ApplicationListener<PublishEventA> {


    @Override
    public void onApplicationEvent(PublishEventA event) {
        PublishBeanA source = (PublishBeanA)event.getSource();
        log.info("监听到事件：{}", JSON.toJSONString(source));
    }
}
