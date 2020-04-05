package com.fyh.springbootsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
@EnableWebMvc
public class SpringBootSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSourceApplication.class, args);
    }


    @Component
    class abc{

    }
}
