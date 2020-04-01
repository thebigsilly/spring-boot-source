package com.fyh.springbootsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringBootSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSourceApplication.class, args);
    }

}
