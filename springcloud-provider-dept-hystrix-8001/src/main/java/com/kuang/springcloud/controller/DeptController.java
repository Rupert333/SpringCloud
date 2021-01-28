package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/module/dept", method = {RequestMethod.GET, RequestMethod.POST})
public class DeptController {

    @Autowired
    private DeptService deptService;


    /**
     * Title: 根据id查询数据的方法,
     *
     * @Param:
     * @Return:
     * @Author: yyg
     * @Date: 2021/1/14 下午2:29
     */
    @GetMapping("/getDeptById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGetDeptById")
    public Dept getDeptById(@PathVariable("id") Long id) {
        Dept dept = deptService.selDeptById(id);
        if (null == dept) {
            throw new RuntimeException("id=》" + id + ",为空不执行操作");
        }
        return dept;
    }

    /**
     * Title: 熔断方法,
     * 
     * @Param: id
     * @Return: dept
     * @Author: yyg
     * @Date: 2021/1/27 下午2:11
     */
    public Dept hystrixGetDeptById(@PathVariable("id") Long id) {
        Dept dept = new Dept();
        dept.setDeptno(id)
                .setDname("id为空")
                .setDb_source("没有查询到对应的数据源");
        return dept;
    }


}
