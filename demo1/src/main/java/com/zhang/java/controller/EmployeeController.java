package com.zhang.java.controller;

import com.zhang.java.dao.DepartmentDao;
import com.zhang.java.dao.EmployeeDao;
import com.zhang.java.domain.Department;
import com.zhang.java.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Author zsy
 * @Create 2020/4/16 11:09
 * @Description
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工信息，返回list.html
     *
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String emps(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /**
     * 查询员工部门信息，返回员工添加界面
     *
     * @param map
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        return "emp/add";
    }

    /**
     * 添加员工，重定向到"/emps"
     *
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    /**
     * 根据员工id查询到员工信息和部门信息，返回员工修改界面
     *
     * @param id
     * @param modelMap
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        Employee employee = employeeDao.get(id);
        modelMap.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.addAttribute("depts", departments);
        return "emp/edit";
    }

    /**
     * 修改员工，重定向到"/emps"
     *
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String editEmp(Employee employee) {
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    /**
     * 根据员工id删除员工，重定向到"/emps"
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
