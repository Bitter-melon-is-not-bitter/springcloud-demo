package com.tang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_GateWay_App {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_GateWay_App.class, args);
    }
}
