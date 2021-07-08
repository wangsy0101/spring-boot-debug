package cn.wangsy.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Created by wangsy on 2021/7/8
 */

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnMyConfigurationCondition.class)
public @interface ConditionalOnMyConfiguration {



}






