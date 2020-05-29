package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept){
        Boolean object = restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return object;
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        List depts = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return depts;
    }
}
