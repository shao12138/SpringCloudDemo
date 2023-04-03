package com.nudt.server_provider_1.Controller;

import com.nudt.server_provider_1.Mapper.UserDao;
import com.nudt.server_provider_1.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoadBalancerClient loadBalancerClient;  //打印端口号

    @GetMapping("/get/{id}")
    public User findById(@PathVariable String id) {
        User a = userDao.findUser(Integer.parseInt(id));
        System.out.println("8081处理请求");
        return a;
    }
}
