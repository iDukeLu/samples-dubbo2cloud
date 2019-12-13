package com.sekorm.examples.eureka.client2.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class EurekaClient2Controller {

    @Value("${spring.application.name}")
    private String app;

    @GetMapping("/eureka-client2")
    public String getFeignClient2() {
        System.err.println(app);
        return app;
    }
}
