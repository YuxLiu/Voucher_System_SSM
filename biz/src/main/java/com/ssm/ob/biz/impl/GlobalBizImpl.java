package com.ssm.ob.biz.impl;

import com.ssm.ob.biz.GlobalBiz;
import com.ssm.ob.dao.EmployeeDao;
import com.ssm.ob.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    private EmployeeDao employeeDao;

    @Autowired
    public GlobalBizImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
