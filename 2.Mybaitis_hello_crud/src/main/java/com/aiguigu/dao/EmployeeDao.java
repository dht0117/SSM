package com.aiguigu.dao;

import com.atguigu.bean.Employee;

public interface EmployeeDao {
    public Employee getEmpById(Integer id);

    public int deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);

    public int updateEmployee(Employee employee);
}
