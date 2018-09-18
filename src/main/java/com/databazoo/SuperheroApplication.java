package com.databazoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SuperheroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperheroApplication.class, args);
    }
}


