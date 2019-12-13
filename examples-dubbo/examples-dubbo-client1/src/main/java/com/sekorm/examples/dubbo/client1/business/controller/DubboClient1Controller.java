package com.sekorm.examples.dubbo.client1.business.controller;

import com.sekorm.examples.dubbo.client1.business.service.DubboClient1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class DubboClient1Controller {

    private DubboClient1Service dubboClient1Service;

    @Autowired
    public DubboClient1Controller(DubboClient1Service dubboClient1Service) {
        this.dubboClient1Service = dubboClient1Service;
    }

    @GetMapping("/dubbo-client1")
    public String getDubboClient1() {
        return dubboClient1Service.getDubboClient1();
    }

    @GetMapping("/dubbo-client1/dubbo-client2")
    public String getDubboClient1DubboClient2() {
        return dubboClient1Service.getDubboClient1DubboClient2();
    }

    @GetMapping("/dubbo-client1/eureka-client2")
    public String getDubboClient1EurekaClient2() {
        return dubboClient1Service.getDubboClient1EurekaClient2();
    }

}
