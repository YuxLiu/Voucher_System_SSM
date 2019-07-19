package com.ssm.ob.controller;

import com.ssm.ob.biz.DepartmentBiz;
import com.ssm.ob.biz.EmployeeBiz;
import com.ssm.ob.entity.Department;
import com.ssm.ob.entity.Employee;
import com.ssm.ob.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeBiz employeeBiz;
    @Autowired
    private DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", employeeBiz.getAll());
        return "employee_list"; // 转发到 jsp 页面上 (Resolver 配置中有 prefix 和 suffix)
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("employee", new Employee());
        // 添加, 修改 员工界面需要选择 部门(department) 职位(Constant.POST)
        map.put("dlist", departmentBiz.getAll());
        map.put("plist", Constant.getPosts());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        // 据说 mvc 会自动将页面收集的信息封装为 Department 对象, I doubt that
        employeeBiz.add(employee);
        // 重定向到控制器,直接去 department_list 静态页面是没有信息的, 要经过 map.put 添加信息
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "sn") // 使用 params 要求提供 sn
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("employee", employeeBiz.get(sn));
        // 添加, 修改 员工界面需要选择 部门(department) 职位(Constant.POST)
        map.put("dlist", departmentBiz.getAll());
        map.put("plist", Constant.getPosts());
        return "employee_update";
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", params = "sn")
    public String remove(String sn) {
        employeeBiz.remove(sn);
        return "redirect:list";
    }
}
