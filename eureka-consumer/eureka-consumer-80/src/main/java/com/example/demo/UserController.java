package com.example.demo;

import com.example.demo.service.IUserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    //private static final String SERVER = "http://127.0.0.1:7001/";
    //private static final String SERVER = "http://EUREKA-PROVIDER/";


    @Autowired
    private IUserService server;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Long id) {
        return server.getUser(id);
    }

    /*@Autowired
    private RestTemplate restTemplate;

    @GetMapping("call-provider/{id}")
    public User findbyid(@PathVariable Long id) {
        return restTemplate.getForObject(SERVER + "user/" + id, User.class, id);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }*/
}
