package com.tang;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUDSERVICE-DEPT", configuration = MySelfRule.class)
public class CloudConsumer80_App {

    //@Bean
    //@LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具
    //public RestTemplate get() {
    //    return new RestTemplate();
    //}

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumer80_App.class, args);
    }
}
