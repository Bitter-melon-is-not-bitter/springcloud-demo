package com.tang.service;

import com.tang.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//不要忘记加
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDId(id).setDName("该ID：" + id + "没有对应信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭").setDSource("no this database in MySql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
