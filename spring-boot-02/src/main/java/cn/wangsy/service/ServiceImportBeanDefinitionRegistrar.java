package cn.wangsy.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;



public class ServiceImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        BeanDefinition service5A = new RootBeanDefinition(Service5A.class);
        BeanDefinition service5B = new RootBeanDefinition(Service5B.class);
        registry.registerBeanDefinition("service5A", service5A);
        registry.registerBeanDefinition("service5B", service5B);
    }
}


