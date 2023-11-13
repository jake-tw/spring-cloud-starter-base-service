package com.jake.webstore.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jake.webstore")
public class WebstoreSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebstoreSsoApplication.class, args);
    }

}
