package org.egovframe.cloud.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan({"org.egovframe.cloud.common", "org.egovframe.cloud.servlet", "org.egovframe.cloud.portalservice", "org.egovframe.cloud.userservice"})
@EntityScan({"org.egovframe.cloud.servlet.domain",  "org.egovframe.cloud.portalservice.domain", "org.egovframe.cloud.userservice.domain"})
@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
