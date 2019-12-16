package com.sekorm.examples.eureka.general.adapter.eureka.client2;

import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.eurekaclient2.EurekaClient2Dubbo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component
public class EurekaClient2Adapter implements EurekaClient2Dubbo {

    @Autowired
    private EurekaClient2Feign eurekaClient2Feign;

    @Override
    public String getEurekaClient2() {
        String result = eurekaClient2Feign.getEurekaClient2();
        System.err.println(result);
        return result;
    }
}
