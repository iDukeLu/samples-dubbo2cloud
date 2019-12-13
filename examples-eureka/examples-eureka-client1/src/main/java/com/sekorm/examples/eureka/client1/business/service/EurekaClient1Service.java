package com.sekorm.examples.eureka.client1.business.service;

public interface EurekaClient1Service {

    /**
     * 获取 EurekaClient1
     * @return FeignClient1
     */
    String getEurekaClient1();

    /**
     * 获取 EurekaClient1 -> EurekaClient2
     * @return EurekaClient1 -> EurekaClient2
     */
    String getEurekaClient1EurekaClient2();

    /**
     * 获取 EurekaClient1 -> DubboClient2
     * @return EurekaClient1 -> DubboClient2
     */
    String getEurekaClient1EurekaDubboClient2();
}
