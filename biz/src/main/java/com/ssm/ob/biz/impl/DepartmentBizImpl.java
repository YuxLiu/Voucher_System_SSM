package com.ssm.ob.biz.impl;

import com.ssm.ob.biz.DepartmentBiz;
import com.ssm.ob.dao.DepartmentDao;
import com.ssm.ob.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentBizImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
