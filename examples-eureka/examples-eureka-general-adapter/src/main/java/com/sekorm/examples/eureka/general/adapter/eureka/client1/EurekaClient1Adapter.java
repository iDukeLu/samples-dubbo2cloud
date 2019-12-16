package com.sekorm.examples.eureka.general.adapter.eureka.client1;

import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.eurekaclient1.EurekaClient1Dubbo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component
public class EurekaClient1Adapter implements EurekaClient1Dubbo {

    @Autowired
    private EurekaClient1Feign eurekaClient1Feign;

    @Override
    public String getEurekaClient1() {
        String result = eurekaClient1Feign.getEurekaClient1();
        System.err.println(result);
        return result;
    }
}
