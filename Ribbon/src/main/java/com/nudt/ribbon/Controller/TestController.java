package com.nudt.ribbon.Controller;

import com.nudt.ribbon.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public User getUser() {
        User user = null;
        // 循环10次，然后可以看到各个用户微服务后台的日志打印
        for (int i = 0; i < 10; i++) {
            // 注意，这里直接使用了USER这个服务ID，代表用户微服务系统
            // 该ID通过属性spring.application.name来指定
            user = restTemplate.getForObject(
                    "http://SpringCloud/get/" + 1, User.class);
        }
        return user;
    }
}