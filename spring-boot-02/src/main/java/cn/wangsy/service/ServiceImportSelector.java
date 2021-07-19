package cn.wangsy.service;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class ServiceImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("====== selectImports ==== ");
        return new String[]{Service4A.class.getName(), Service4B.class.getName()};
    }
}



