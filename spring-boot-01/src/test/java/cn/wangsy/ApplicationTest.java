package cn.wangsy;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangsy on 2021/7/7
 */

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Autowired
    private StringRedisTemplate redisTemplate;

    //@org.junit.Test
    @org.junit.jupiter.api.Test  // 该测试注解可以不用写 @RunWith(SpringRunner.class)
    public void test01(){
        System.out.println("========");
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        System.out.println(connectionFactory);
        System.out.println(((JedisConnectionFactory) connectionFactory).getPoolConfig().getMaxIdle());
        System.out.println(((JedisConnectionFactory) connectionFactory).getPoolConfig().getMinIdle());
        System.out.println(((JedisConnectionFactory) connectionFactory).getPoolConfig().getMaxTotal());
        System.out.println("========");

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("hello", "world");

        String value = stringStringValueOperations.get("hello");
        System.out.println("======= " + value);
    }
}
