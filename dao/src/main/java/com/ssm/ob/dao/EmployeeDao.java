package com.ssm.ob.dao;

import com.ssm.ob.entity.Department;
import com.ssm.ob.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    void insert(Employee employee);

    void update(Employee employee);

    void delete(String sn);

    Employee select(String sn);

    List<Employee> selectAll();

    List<Employee> selectByDepartmentAndPost(@Param("d_sn") String d_sn, @Param("post") String post);
}
