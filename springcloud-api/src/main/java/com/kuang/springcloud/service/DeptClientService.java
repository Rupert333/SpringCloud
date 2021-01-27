package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT-YYG")
public interface DeptClientService {

    @GetMapping("/module/dept/add")
    boolean add(Dept dept);

    @GetMapping("/module/dept/getDeptById/{id}")
    Dept queryById(Long id);

    @GetMapping("/module/dept/getAllDept")
    List<Dept> getAllDept();
}
