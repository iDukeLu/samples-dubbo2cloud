package com.sekorm.examples.eureka.general.adapter.eureka.client2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * EurekaClient2
 */
@FeignClient("eureka-client2")
@RequestMapping("/example")
public interface EurekaClient2Feign {

    @GetMapping("/eureka-client2")
    String getEurekaClient2();
}



