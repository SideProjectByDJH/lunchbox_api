package com.djh.lunchbox_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(value = "com.djh.lunchbox_api.entity")
public class LunchboxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchboxApiApplication.class, args);
    }
}
