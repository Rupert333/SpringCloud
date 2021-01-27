package com.kuang.spingcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: 客户端请求,
 *
 * @author yangyuegang
 * @create: 2021/1/17
 */
@RestController
@RequestMapping("/module/consumer")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

//     private static final String REST_URL_PREFIX="http://localhost:8001/module/dept";
    // Ribbon 我们这里的地址，应该是一个变量，通过服务名称来访问
//    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT-YYG/module/dept";
    // 通过Feign请求
    @Autowired
    private DeptClientService deptClientService=null;

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
        return this.deptClientService.add(dept);
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
        return this.deptClientService.queryById(id);
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
        return this.deptClientService.getAllDept();
    }
}
