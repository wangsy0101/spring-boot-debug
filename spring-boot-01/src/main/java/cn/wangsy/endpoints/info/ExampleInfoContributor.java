package cn.wangsy.endpoints.info;

import com.google.common.collect.Maps;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

/**
 * Created by wangsy on 2021/7/8
 */
@Component
public class ExampleInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("111", "222").withDetails(Collections.singletonMap("key", "value"));
    }
}
