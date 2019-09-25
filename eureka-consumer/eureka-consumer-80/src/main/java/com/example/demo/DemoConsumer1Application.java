package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.demo.service"})
@EnableHystrix
public class DemoConsumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(DemoConsumer1Application.class, args);
    }
}
