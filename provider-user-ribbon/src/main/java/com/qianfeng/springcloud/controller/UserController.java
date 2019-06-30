package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private EurekaClient eurekaclient;

    @GetMapping("/user/{id}")
    public User getuser(@PathVariable Long id){
        return new User(id);
    }

    @GetMapping("/eurekainfo")
    public  String info(){
        InstanceInfo instanceinfo = eurekaclient.getNextServerFromEureka("PROVIDER-USER",false);
        return  instanceinfo.getHomePageUrl();
    }
}
