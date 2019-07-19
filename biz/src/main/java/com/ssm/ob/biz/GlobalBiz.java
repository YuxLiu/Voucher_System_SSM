package com.ssm.ob.biz;

import com.ssm.ob.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
