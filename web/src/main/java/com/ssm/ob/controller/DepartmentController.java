package com.ssm.ob.controller;

import com.ssm.ob.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import com.ssm.ob.biz.DepartmentBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", departmentBiz.getAll());
        return "department_list"; // 转发到 jsp 页面上 (Resolver 配置中有 prefix 和 suffix)
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("department", new Department());
        return "department_add";
    }

    @RequestMapping("/add")
    public String add(Department department) {
        // 据说 mvc 会自动将页面收集的信息封装为 Department 对象, I doubt that
        departmentBiz.add(department);
        // 重定向到控制器,直接去 department_list 静态页面是没有信息的, 要经过 map.put 添加信息
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "sn") // 使用 params 要求提供 sn
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("department", departmentBiz.get(sn));
        return "department_update";
    }

    @RequestMapping("/update")
    public String update(Department department) {
        departmentBiz.edit(department);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", params = "sn")
    public String remove(String sn) {
        departmentBiz.remove(sn);
        return "redirect:list";
    }
}
