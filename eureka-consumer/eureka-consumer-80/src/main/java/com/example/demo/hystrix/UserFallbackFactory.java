package com.example.demo.hystrix;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component //一定要加
public class UserFallbackFactory implements FallbackFactory<IUserService> {
    @Override
    public IUserService create(Throwable throwable) {
        IUserService service = new IUserService() {
            @Override
            public User getUser(Long id) {
                User user = new User();
                user.setArea1("444");
                user.setArea2("444");
                return user;
            }
        };
        return service;
    }
}
