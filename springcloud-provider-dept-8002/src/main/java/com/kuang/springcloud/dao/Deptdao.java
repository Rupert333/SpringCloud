package com.kuang.springcloud.dao;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Deptdao {
    boolean addDept(Dept dept);

    Dept queryById(long id);

    List<Dept> queryAll();
}
