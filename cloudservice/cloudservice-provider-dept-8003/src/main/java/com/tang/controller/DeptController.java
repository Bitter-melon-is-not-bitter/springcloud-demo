package com.tang.controller;

import com.tang.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.tang.service.DeptService;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        //System.out.println("DeptController:" + deptService.get(id));
        return deptService.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List list() {
        return deptService.list();
    }

    /**
     * 服务发现
     *
     * @return
     */
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        //盘点eureka中有多少个微服务
        List<String> list = client.getServices();
        System.out.println("*************" + list);

        //找到微服务中名字为CLOUDSERVICE-DEPT的信息
        List<ServiceInstance> serviceInstanceList = client.getInstances("CLOUDSERVICE-DEPT");
        for (ServiceInstance element : serviceInstanceList) {
            System.out.print(element.getServiceId() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }

}
