package com.kuang.spingcloud;

import com.kuang.yygRule.YygRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT-YYG",configuration = YygRandomRule.class)
public class Consumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80.class,args);
    }
}
