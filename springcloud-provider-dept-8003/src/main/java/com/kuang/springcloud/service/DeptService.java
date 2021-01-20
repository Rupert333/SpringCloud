package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * @Remarks 新增
     * @author yyg
     * @date 2021/1/14
     **/
    boolean add(Dept dept);

    /**
     * @Remarks 查询所有
     * @author yyg
     * @date 2021/1/14
     **/
    Dept selDeptById(Long id);
    
    /**
     * @Remarks 查询所有
     * @author yyg
     * @date 2021/1/14
     **/
    List<Dept> selAllDept();
}
