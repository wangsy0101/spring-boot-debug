package cn.wangsy.config;

import cn.wangsy.service.Service3;
import cn.wangsy.service.ServiceImportBeanDefinitionRegistrar;
import cn.wangsy.service.ServiceImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;




@Import({Service3.class, ImportConfiguration2.class, ServiceImportSelector.class, ServiceImportBeanDefinitionRegistrar.class})
@Configuration
public class ImportConfiguration {


}


