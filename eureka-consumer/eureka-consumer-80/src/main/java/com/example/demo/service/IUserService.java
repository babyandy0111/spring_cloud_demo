package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.hystrix.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-PROVIDER", fallbackFactory = UserFallbackFactory.class)
public interface IUserService {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id);

}