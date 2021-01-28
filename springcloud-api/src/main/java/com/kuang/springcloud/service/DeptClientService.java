package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT-YYG")
public interface DeptClientService {

    @RequestMapping("/module/dept/add")
    boolean add(Dept dept);

    @RequestMapping("/module/dept/getDeptById/{id}")
    Dept queryById(@PathVariable("id")Long id);

    @RequestMapping("/module/dept/getAllDept")
    List<Dept> getAllDept();
}
