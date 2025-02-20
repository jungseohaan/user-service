package com.clbee.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.Security;

@ComponentScan({"com.clbee.admin.common", "com.clbee.admin.servlet", "com.clbee.admin.portalservice", "com.clbee.admin.userservice",
        "com.clbee.admin.boardservice" })
@EntityScan({"com.clbee.admin.servlet.domain",
        "com.clbee.admin.portalservice.domain", "com.clbee.admin.userservice.domain", "com.clbee.admin.boardservice.domain"})
@EnableFeignClients
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        // TLSv1/v1.1 No longer works after upgrade, "No appropriate protocol" error
        String property = Security.getProperty("jdk.tls.disabledAlgorithms").replace(", TLSv1", "").replace(", TLSv1.1", "");
        Security.setProperty("jdk.tls.disabledAlgorithms", property);

        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
