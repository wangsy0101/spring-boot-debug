package cn.wangsy.annotation;

import cn.wangsy.config.MyConfiguration;
import cn.wangsy.config.WebConfiguration;
import cn.wangsy.entity.Account;
import cn.wangsy.entity.Person;
import cn.wangsy.service.Service1;
import cn.wangsy.service.Service2;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by wangsy on 2021/7/8
 */
public class OnMyConfigurationCondition extends AllNestedConditions {


    OnMyConfigurationCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnBean(Service1.class)
    static class service1 {

    }

    @ConditionalOnBean(Service2.class)
    static class service2 {

    }




}
