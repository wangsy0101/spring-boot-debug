package cn.wangsy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAdminServer
@SpringBootApplication
public class ApplicationAdmin {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAdmin.class, args);
    }

}


