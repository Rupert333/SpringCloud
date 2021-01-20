package com.kuang.springcloud.manager;


import com.kuang.springcloud.dao.Deptdao;
import com.kuang.springcloud.pojo.Dept;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DeptManager {

    @Resource
    private Deptdao deptdao;

    /**
     * Title: 新增部门方法,
     * 
     * @Author: yyg
     * @Date: 2021/1/14 下午1:31
     */
    public boolean add(Dept dept) {
        return deptdao.addDept(dept);
    }

    /**
     * Title: 根据id查询信息,
     * 
     * @Param: id
     * @Return: dept
     * @Author: yyg
     * @Date: 2021/1/14 下午2:44
     */
    public Dept selDeptById(Long id) {
        return deptdao.queryById(id);
    }


    /**
     * Title: 查询所有数据,
     * 
     * @Return: List<Dept>
     * @Author: yyg
     * @Date: 2021/1/14 下午2:44
     */
    public List<Dept> selAllDept() {
        return deptdao.queryAll();
    }

}
