package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID " + id + "的信息不存在，Consumer客户端提供的降级信息，此刻服务Provider已经关闭。").setDb_source("no this db in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
