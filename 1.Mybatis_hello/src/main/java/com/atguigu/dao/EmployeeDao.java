package com.atguigu.dao;

import com.atguigu.bean.Employee;

public interface EmployeeDao {
    //按照员工id查询员工
    //需要导入数据库连接驱动包和mybatis包
    public Employee getEmpById(Integer id);


}
