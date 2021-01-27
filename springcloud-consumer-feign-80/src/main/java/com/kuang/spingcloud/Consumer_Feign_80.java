package com.kuang.spingcloud;

import com.kuang.yygRule.YygRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT-YYG",configuration = YygRandomRule.class)
@EnableFeignClients(basePackages = {"com.kuang.springcloud"})
@ComponentScan("com.kuang.springcloud")
public class Consumer_Feign_80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Feign_80.class,args);
    }
}
