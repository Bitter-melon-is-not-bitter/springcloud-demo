package com.tang.service;

import com.tang.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "CLOUDSERVICE-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)//降级和Feign
@RequestMapping(value = "/dept")
public interface DeptClientService {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list();
}
