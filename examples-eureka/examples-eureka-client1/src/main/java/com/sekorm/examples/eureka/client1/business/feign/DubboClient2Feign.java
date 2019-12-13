package com.sekorm.examples.eureka.client1.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FeignClient2
 */
@FeignClient("dubbo-client2")
@RequestMapping("/example")
public interface DubboClient2Feign {
    @GetMapping("/dubbo-client2")
    String getDubboClient2();
}
