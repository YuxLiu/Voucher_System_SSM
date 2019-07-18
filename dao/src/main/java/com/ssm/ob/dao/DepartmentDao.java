package com.ssm.ob.dao;

import com.ssm.ob.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// 添加("departmentDao") 会导致 biz.departmentDao bean 要求 qualify
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
