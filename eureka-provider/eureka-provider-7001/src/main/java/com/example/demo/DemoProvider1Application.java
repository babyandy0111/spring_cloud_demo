package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.example.demo.dao")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DemoProvider1Application {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoProvider1Application.class, args);
    }

    @RequestMapping("user/{id}")
    public User home(@PathVariable Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setArea1("1");
        return user;
    }
}
