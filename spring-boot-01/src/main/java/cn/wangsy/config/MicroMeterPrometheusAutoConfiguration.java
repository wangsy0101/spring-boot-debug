package cn.wangsy.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterRegistryConfig;
import io.micrometer.prometheus.PrometheusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangsy on 2021/6/7
 */
@ConditionalOnClass({MeterRegistryConfig.class, PrometheusConfig.class})
@Configuration
public class MicroMeterPrometheusAutoConfiguration {


    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> {
            registry.config().commonTags(new String[]{"application", applicationName});
        };
    }


}
