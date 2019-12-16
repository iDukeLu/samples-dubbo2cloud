package com.sekorm.examples.eureka.general.adapter.eureka.client1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * EurekaClient2
 */
@FeignClient("eureka-client1")
@RequestMapping("/example")
public interface EurekaClient1Feign {

    @GetMapping("/eureka-client1")
    String getEurekaClient1();
}



