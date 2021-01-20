package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/module/dept",method ={ RequestMethod.GET,RequestMethod.POST})
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    /**
     * Title: 新增数据的方法,
     *
     * @Param:
     * @Return:
     * @Author: yyg
     * @Date: 2021/1/14 上午11:15
     */
    @GetMapping("/add")
    public boolean add(Dept dept){
        return deptService.add(dept);
    }
    
    /**
     * Title: 根据id查询数据的方法,
     * 
     * @Param:
     * @Return:
     * @Author: yyg
     * @Date: 2021/1/14 下午2:29
     */
    @GetMapping("/getDeptById/{id}")
    public Dept getDeptById(@PathVariable("id")Long id){
        return deptService.selDeptById(id);
    }

    /**
     * Title: 获取所有数据的fangfa,
     *
     * @Param:
     * @Return:
     * @Author: yyg
     * @Date: 2021/1/14 下午2:33
     */
    @GetMapping("/getAllDept")
    public List<Dept> getAllDept(){
        return deptService.selAllDept();
    }
    
    /**
     * Title: 获取注册中心相关信息,
     * 
     * @Author: yyg
     * @Date: 2021/1/17 下午9:43
     */
    @GetMapping("/discover")
    public Object discover(){
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("discover=>services"+services);


        //获取微服务示例清单
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT-YYG");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getUri()+"\n"+
                    instance.getHost()+"\n"+
                    instance.getPort()+"\n"+
                    instance.getServiceId()
            );
        }
        return this.client;
    }

}
