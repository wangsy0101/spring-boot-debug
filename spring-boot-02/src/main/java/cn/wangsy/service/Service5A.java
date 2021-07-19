package cn.wangsy.service;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by wangsy on 2021/7/13
 */
public class Service5A  {

    public void hello(){
        System.out.println("this is service5A");
    }
}
