package com.kuang.spingcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Title: 客户端请求,
 *
 * @author yangyuegang
 * @create: 2021/1/17
 */
@RestController
@RequestMapping("/module/dept")
public class ConsumerController {

    @Autowired
    private DeptClientService service=null;

    /**
     * Title: 增加部门方法,
     * 
     * @Param: Dept dept 实体类
     * @Return: boolean 是否成功
     * @Author: yyg
     * @Date: 2021/1/17 下午7:50
     */
    @RequestMapping("/add")
    public boolean add(Dept dept){
        return this.service.add(dept);
    }
    
    /**
     * Title: 根据id获取信息,
     * 
     * @Param: long id
     * @Return: dept 实体类
     * @Author: yyg
     * @Date: 2021/1/17 下午7:51
     */
    @RequestMapping("/getDeptById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }
    
    /**
     * Title: 获取所有部门信息的方法,
     * 
     * @Return: List<Dept>
     * @Author: yyg
     * @Date: 2021/1/17 下午7:52
     */
    @RequestMapping("/getAllDept")
    public List<Dept> getAllDept(){
        return this.service.getAllDept();
    }

    @RequestMapping("/test")
    public String test(){
        String str="test Info ----------------------------------------------------";
        System.out.println(str);
        return str;
    }

}
