package org.egovframe.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.Security;

@ComponentScan({"org.egovframe.cloud.common", "org.egovframe.cloud.servlet", "org.egovframe.cloud.portalservice", "org.egovframe.cloud.userservice",
        "org.egovframe.cloud.reactive",
        "org.egovframe.cloud.reservechecksevice", "org.egovframe.cloud.reserverequestservice","org.egovframe.cloud.reserveitemservice"})
@EntityScan({"org.egovframe.cloud.servlet.domain",
        "org.egovframe.cloud.portalservice.domain", "org.egovframe.cloud.userservice.domain"})
@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        // TLSv1/v1.1 No longer works after upgrade, "No appropriate protocol" error
        String property = Security.getProperty("jdk.tls.disabledAlgorithms").replace(", TLSv1", "").replace(", TLSv1.1", "");
        Security.setProperty("jdk.tls.disabledAlgorithms", property);

        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
