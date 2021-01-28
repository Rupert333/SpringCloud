package com.kuang.springcloud.service.impl;

import com.kuang.springcloud.manager.DeptManager;
import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptManager deptManager;

    @Override
    public boolean add(Dept dept) {
        return deptManager.add(dept);
    }

    @Override
    public Dept selDeptById(Long id) {
        return deptManager.selDeptById(id);
    }

    @Override
    public List<Dept> selAllDept() {
        return deptManager.selAllDept();
    }
}
