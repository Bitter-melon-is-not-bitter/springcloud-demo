package com.tang.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


//@AllArgsConstructor//全参的构造函数
@NoArgsConstructor//无参构造函数
@Data//每个方法生成set get
@Accessors(chain = true)//链式风格设置
public class Dept implements Serializable {

    private Long dId; //主键
    private String dName; //部门
    private String dSource;//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库

    public Dept(String dName) {
        this.dName = dName;
    }

    //public static void main(String[] args) {
    //    Dept dept = new Dept();
    //    dept.setDName("Java研发部").setDNo(1L).setDSource("db_1");
    //    System.out.println(dept);
    //}
}
