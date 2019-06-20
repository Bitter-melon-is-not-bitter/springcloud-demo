package com.tang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用集群
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类，接收其他微服务注册进来的注解
public class EurekaServer7002_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002_App.class, args);
    }
}
