package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept){
        Boolean object = deptClientService.add(dept);
        return object;
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptClientService.get(id);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        List depts = deptClientService.list();
        return depts;
    }

//    @RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
//    public Object discovery(){
//        Object o = restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//        return o;
//    }
}
