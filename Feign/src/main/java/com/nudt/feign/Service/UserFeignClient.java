package com.nudt.feign.Service;

import com.nudt.feign.Pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SpringCloud")
public interface UserFeignClient {
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") String id);
}