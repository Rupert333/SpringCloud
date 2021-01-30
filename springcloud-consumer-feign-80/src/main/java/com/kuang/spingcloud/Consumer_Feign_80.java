package com.kuang.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.kuang.springcloud"})  //需要扫描使用@FeignClient的接口的包
/*当只有一个ComponentScan的时候，SpringBootApplication是不会被加载的.但是如果取消的话，在后面的降级处理加入feign:配置的时候，服务将无法启动。
 解决办法是使用@ComponentScans({@ComponentScan("com.leon.springcloud.service")}) 代替componentScan这种方法可以让@SpringBootApplication
 和 多个@ComponentScan("com.leon.springcloud.service") 共存。*/
//@ComponentScan("com.kuang.springcloud")  //这样配置启动会找不到错误
@ComponentScans({@ComponentScan("com.kuang.springcloud")})
public class Consumer_Feign_80 {
    /**
     * 这个类是和consumer-dept-80那个module作用是一样的，而且都是使用80端口，只是consumer那个module用的请求方法不一样而已
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Feign_80.class,args);
    }
}
