package com.nudt.feign.Controller;

import com.nudt.feign.Pojo.User;
import com.nudt.feign.Service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRequestController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/test")
    public User getA() {
        // 注入Feign接口
        User user = null;
        // 循环10次
        for (int i = 0; i < 10; i++) {
            Long id = (long) (i + 1);
            user = userFeignClient.findById(id + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }
}