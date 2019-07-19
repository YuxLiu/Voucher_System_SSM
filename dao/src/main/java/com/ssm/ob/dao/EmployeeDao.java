package com.ssm.ob.dao;

import com.ssm.ob.entity.Department;
import com.ssm.ob.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// 添加("departmentDao") 会导致 biz.departmentDao bean 要求 qualify
public interface EmployeeDao {
    void insert(Employee employee);

    void update(Employee employee);

    void delete(String sn);

    Employee select(String sn);

    List<Employee> selectAll();
}
