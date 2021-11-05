package cn.wangsy.controller.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by wangsy on 2021/11/5
 */
@Slf4j
@Service
public class PublishListenerA3 {


    @EventListener
    public void listener(PublishEventA event) {
        PublishBeanA source = (PublishBeanA)event.getSource();
        log.info("监听到事件：{}", JSON.toJSONString(source));
    }
}
