package cn.wangsy.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by wangsy on 2021/5/19
 */
@Setter
@Getter
public class Account {

    private Long id;
    private String name;
    private Integer balance;


}

