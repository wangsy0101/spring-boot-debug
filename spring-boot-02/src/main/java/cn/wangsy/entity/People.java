package cn.wangsy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wangsy on 2021/7/6
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class People {

    private String name;
    private Integer age;
}
