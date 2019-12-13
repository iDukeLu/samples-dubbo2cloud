package com.sekorm.examples.dubbo.client1.business.service.impl;

import com.sekorm.examples.dubbo.client1.business.service.DubboClient1Service;
import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.dubboclient2.DubboClient2Dubbo;
import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.eurekaclient2.EurekaClient2Dubbo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DubboClient1ServiceImpl implements DubboClient1Service {

    @Value("${spring.application.name}")
    private String app;

    @Reference
    private DubboClient2Dubbo dubboClient2Dubbo;

    @Reference
    private EurekaClient2Dubbo eurekaClient2Dubbo;

    @Override
    public String getDubboClient1() {
        System.err.println(app);
        return app;
    }

    @Override
    public String getDubboClient1DubboClient2() {
        String s = app + " -> " + dubboClient2Dubbo.getDubboClient2();
        System.err.println(s);
        return s;
    }

    @Override
    public String getDubboClient1EurekaClient2() {
        String s = app + " -> " + eurekaClient2Dubbo.getEurekaClient2();
        System.err.println(s);
        return s;
    }
}
