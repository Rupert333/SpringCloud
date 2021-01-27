package com.kuang.spingcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //配置Ribbon负载均衡 IRule
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new  RestTemplate();
    }

}
