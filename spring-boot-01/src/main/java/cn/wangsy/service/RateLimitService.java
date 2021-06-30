package cn.wangsy.service;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangsy on 2021/6/11
 */
@Service
@Slf4j
public class RateLimitService {


    AtomicInteger atomicInteger1 = new AtomicInteger(0);
    AtomicInteger atomicInteger2 = new AtomicInteger(0);

    private RateLimiter rateLimiter =  RateLimiter.create(20000);


    public boolean tryAcquire(){
        long start = System.nanoTime();
        boolean result =  rateLimiter.tryAcquire();
//        log.info("======= cost ==== :{}, result:{}", System.nanoTime() - start, result);

        if (result){
            atomicInteger1.incrementAndGet();
        }else {
            atomicInteger2.incrementAndGet();
        }
        System.out.println(atomicInteger1.get() + " ==== " + atomicInteger2.get());
        return result;
    }

    public static void main(String[] args) {
        RateLimitService service = new RateLimitService();
        System.out.println(Objects.equals(service.rateLimiter.getRate(), 2000.0));

        Double a = null;
        service.rateLimiter = RateLimiter.create(a);

        System.out.println(Objects.equals(service.rateLimiter.getRate(), 2000.0));

    }





}
