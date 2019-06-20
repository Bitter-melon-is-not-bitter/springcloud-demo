package com.tang.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * RestTemplate提供了多种便捷访问远程Http服务的方法，
 * 是一种简单便捷的访问restful服务模版
 * 是spring提供的用于访问Rest服务的客户端模版工具集
 * <p>
 * （url，requestMap，ResponseBean.class）这三个参数分别代表Rest请求地址、请求参数、
 * HTTP响应转换被转换成的对象类型
 */
@Configuration
public class ConfigBean {

    /**
     * 将Ribbon添加到RestTemplate
     *
     * @return
     */
    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具
    public RestTemplate get() {
        return new RestTemplate();
    }

    /**
     * 设置Ribbon的负载均衡策略 IRule中有七个策略
     *
     * @return
     */
    //@Bean
    //public IRule myRule() {
    //    return new RoundRobinRule();
    //}

    //@Bean
    //public RestTemplate restTemplate() {
    //    RestTemplate restTemplate = new RestTemplate();
    //    restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));//把编码格式设置为UTF-8格式。
    //    return restTemplate;
    //}
}
