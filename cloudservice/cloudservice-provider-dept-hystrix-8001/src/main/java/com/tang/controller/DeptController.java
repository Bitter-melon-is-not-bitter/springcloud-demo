package com.tang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tang.entities.Dept;
import com.tang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
    @HystrixCommand(fallbackMethod = "fallBackDept")//一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand中fallbackMethod指定的方法
    public Dept get(@PathVariable("id") Long id) {
        //System.out.println("DeptController:" + deptService.get(id));
        Dept dept = this.deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有对应信息");
        }
        return dept;
    }

    public Dept fallBackDept(@PathVariable("id") Long id) {
        return new Dept().setDId(id).setDName("该ID：" + id + "没有对应信息，null----@HystrixCommand").setDSource("no this database in MySql");
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
