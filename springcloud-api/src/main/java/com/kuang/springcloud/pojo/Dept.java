package com.kuang.springcloud.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private static final long serialVersionUID= 1133108590339971436L;

    private Long deptno;//主键
    private String dname;
    //数据是存在哪个数据库中的
    private String db_source;
}
