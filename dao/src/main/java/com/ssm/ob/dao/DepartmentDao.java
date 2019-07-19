package com.ssm.ob.dao;

import com.ssm.ob.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

// 添加("departmentDao") 会导致 biz.departmentDao bean 要求 qualify
// 原因猜想: bean 名称默认为接口名, ("alias") 是别名,
//          2 个名称相同 则相当于: 1 个对象同时有 2 个引用
@Repository
public interface DepartmentDao {
    void insert(Department department);

    void update(Department department);

    void delete(String sn);

    Department select(String sn);

    List<Department> selectAll();
}
