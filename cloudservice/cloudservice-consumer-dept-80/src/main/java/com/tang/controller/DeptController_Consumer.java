package com.tang.controller;

import com.tang.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RequestMapping("/consumer/dept")
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001/dept";
    private static final String REST_URL_PREFIX = "http://CLOUDSERVICE-DEPT/dept";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/add", dept, Boolean.class);

    }

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    @RequestMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/list", List.class);
    }

    /**
     * 服务发现
     *
     * @return
     */
    @RequestMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/discovery", Object.class);
    }
}
