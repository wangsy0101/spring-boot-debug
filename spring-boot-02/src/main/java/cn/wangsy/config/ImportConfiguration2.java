package cn.wangsy.config;

import cn.wangsy.service.Service6;
import org.springframework.context.annotation.Bean;



public class ImportConfiguration2 {

    @Bean("service6")
    public Service6 getService6(){
        return new Service6();
    }
}


