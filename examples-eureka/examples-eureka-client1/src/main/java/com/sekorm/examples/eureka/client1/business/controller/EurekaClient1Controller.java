package com.sekorm.examples.eureka.client1.business.controller;

import com.sekorm.examples.eureka.client1.business.service.EurekaClient1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class EurekaClient1Controller {

    private EurekaClient1Service eurekaClient1Service;

    @Autowired
    public EurekaClient1Controller(EurekaClient1Service eurekaClient1Service) {
        this.eurekaClient1Service = eurekaClient1Service;
    }

    @GetMapping("/eureka-client1")
    public String getFeignClient1() {
        return eurekaClient1Service.getEurekaClient1();
    }

    @GetMapping("/eureka-client1/eureka-client2")
    public String getFeignClient1FeignClient2() {
        return eurekaClient1Service.getEurekaClient1EurekaClient2();
    }

    @GetMapping("/eureka-client1/dubbo-client2")
    public String getFeignClient1DubboClient2() {
        return eurekaClient1Service.getEurekaClient1EurekaDubboClient2();
    }

}


