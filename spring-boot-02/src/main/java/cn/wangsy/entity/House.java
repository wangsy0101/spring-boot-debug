package cn.wangsy.entity;

import lombok.Getter;
import lombok.Setter;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by wangsy on 2021/7/1
 */
@ConfigurationProperties(prefix = "myhouse")   // 配置文件注入属性
// @Component   // 替换方式：可以在配置类中增加 @EnableConfigurationProperties(House.class)
@Setter
@Getter

public class House {

    private Integer area;
    private String address;
    private List<String> rooms;
    private List<String> roomList;
    private Map<String, String> map;
    private Map<String, String> map2;



}
