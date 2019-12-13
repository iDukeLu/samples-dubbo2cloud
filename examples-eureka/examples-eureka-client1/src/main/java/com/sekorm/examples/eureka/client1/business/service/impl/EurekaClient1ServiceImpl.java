package com.sekorm.examples.eureka.client1.business.service.impl;

import com.sekorm.examples.eureka.client1.business.feign.DubboClient2Feign;
import com.sekorm.examples.eureka.client1.business.feign.EurekaClient2Feign;
import com.sekorm.examples.eureka.client1.business.service.EurekaClient1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EurekaClient1ServiceImpl implements EurekaClient1Service {

    @Value("${spring.application.name}")
    private String app;

    private EurekaClient2Feign eurekaClient2Feign;

    private DubboClient2Feign dubboClient2Feign;

    @Autowired
    public EurekaClient1ServiceImpl(
            EurekaClient2Feign eurekaClient2Feign,
            DubboClient2Feign dubboClient2Feign) {
        this.eurekaClient2Feign = eurekaClient2Feign;
        this.dubboClient2Feign = dubboClient2Feign;
    }

    @Override
    public String getEurekaClient1() {
        System.err.println(app);
        return app;
    }

    @Override
    public String getEurekaClient1EurekaClient2() {
        String s = app + " -> " + eurekaClient2Feign.getEurekaClient2();
        System.err.println(s);
        return s;
    }

    @Override
    public String getEurekaClient1EurekaDubboClient2() {
        String s = app + " -> " + dubboClient2Feign.getDubboClient2();
        System.err.println(s);
        return s;
    }
}
