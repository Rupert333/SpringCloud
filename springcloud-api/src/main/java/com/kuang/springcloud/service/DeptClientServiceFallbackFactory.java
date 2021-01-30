package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级会调用的类
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {


    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id)
                        .setDname("服务器已经被关闭了,返回的是服务降级的备用信息")
                        .setDb_source("请过一段时间再来访问");
                return dept;
            }

            @Override
            public List<Dept> getAllDept() {
                return null;
            }
        };
    }
}
