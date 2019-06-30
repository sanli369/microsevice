package com.qianfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient("PROVIDER-USER")
public class ConsumerOrderApplication {
   @Bean
    public  RestTemplate  getTemp(){
       return  new RestTemplate();
   }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class);
    }
}
