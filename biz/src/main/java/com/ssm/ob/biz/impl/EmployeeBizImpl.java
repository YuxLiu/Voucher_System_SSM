package com.ssm.ob.biz.impl;

import com.ssm.ob.biz.EmployeeBiz;
import com.ssm.ob.dao.DepartmentDao;
import com.ssm.ob.dao.EmployeeDao;
import com.ssm.ob.entity.Department;
import com.ssm.ob.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {
// idea 提示推荐使用 Constructor 注入, 试试
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeBizImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void add(Employee employee) {
        // 业务层特有: 添加员工时设置默认密码
        employee.setPassword("000000");
        employeeDao.insert(employee);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
