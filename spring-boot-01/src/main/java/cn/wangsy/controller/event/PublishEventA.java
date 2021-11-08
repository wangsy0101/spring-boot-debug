package cn.wangsy.controller.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by wangsy on 2021/11/5
 *
 * 创建事件发布实体对象
 */
@Getter
@Setter
public class PublishEventA extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PublishEventA(PublishBeanA source) {
        super(source);
    }



}


