package com.sekorm.examples.dubbo.client2.adapter.config;

import com.sekorm.examples.eureka.adapter.dubbo.api.business.dubbo.dubboclient2.DubboClient2Dubbo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class DubboClient2Adapter {

    @Reference
    private DubboClient2Dubbo dubboClient2Dubbo;

    @GetMapping("/dubbo-client2")
    public String getDubboClient2() {
        System.err.println(dubboClient2Dubbo.getDubboClient2());
        return dubboClient2Dubbo.getDubboClient2();
    }
}
