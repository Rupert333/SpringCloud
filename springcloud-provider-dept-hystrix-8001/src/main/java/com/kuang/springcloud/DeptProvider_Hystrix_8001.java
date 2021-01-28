package com.kuang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//启动类
@SpringBootApplication
@MapperScan(value = "com.kuang.springcloud.dao")
@EnableEurekaClient //开始注册到eureka
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //开启熔断功能
public class DeptProvider_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001.class,args);
    }


    /**
     * 如果想被dashboard监听到，必须在dashboard里监控某个服务 这个服务本身得先 主启动类上@EnableCircuitBreaker 开启熔断开关
     * 然后注入一个视频里的ServletBean
     * 同时这个服务的控制器里面的接口 必须有@HystrixCommand的注解，用来标识要把哪些接口方法展示在dashboard上(方便理解)
     * */
    //增加一个servlet 用来挂靠 Hystrix dashboard
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
