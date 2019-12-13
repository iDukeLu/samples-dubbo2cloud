package com.sekorm.examples.dubbo.client2.business.dubbo.impl;

import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.dubboclient2.DubboClient2Dubbo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class DubboClient2DubboImpl implements DubboClient2Dubbo {

    @Value("${spring.application.name}")
    private String app;

    @Override
    public String getDubboClient2() {
        System.err.println(app);
        return app;
    }
}
