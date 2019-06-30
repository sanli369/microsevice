package com.qianfeng.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.qianfeng.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate resttemplate;

    @Autowired
    private EurekaClient eurekaclient;

   //@Value("${user.url}")
    private  String  url;

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable  Long id){
        InstanceInfo instanceinfo = eurekaclient.getNextServerFromEureka("PROVIDER-USER",false);
        String homepageurl=instanceinfo.getHomePageUrl();
        User user=resttemplate.getForObject(homepageurl+"/user/"+id,User.class);
        return user;
    }
}
