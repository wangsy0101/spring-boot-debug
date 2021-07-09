package cn.wangsy.endpoints.customer;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsy on 2021/7/8
 */
@Component
@Endpoint(id = "myEndpoint")
public class MyEndpoint {


    @ReadOperation
    public Map read() {
        return Collections.singletonMap("info", "this is read op");
    }


    @WriteOperation
    public Map write() {
        return Collections.singletonMap("info", "this is write op");
    }
}
