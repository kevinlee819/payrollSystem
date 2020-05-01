package com.hust.controller;

import com.hust.beans.Department;
import com.hust.beans.Employee;
import com.hust.beans.Position;
import com.hust.service.DepartmentService;
import com.hust.service.EmployeeService;
import com.hust.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/21
 * @time 14:08
 **/

@Controller
@RequestMapping("basicInfo/")
public class EmployeeController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private PositionService positionService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService, PositionService positionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @ModelAttribute("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @ModelAttribute("departments")
    public List<Department> getAllDeps() {
        return departmentService.getAllDepartments();
    }

    @ModelAttribute("positions")
    public List<Position> getAllPoss() {
        return  positionService.getAllPositions();
    }

    @RequestMapping("employee")
    public String employeeManagement(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "basicInfo/employee/employeeManagement";
    }

    @RequestMapping(value = "employee/doCreateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doCreateEmployee(@RequestBody Employee employee) {
        System.out.println(employee.getEmployeeSex());
        employee.setPriority(1);
        employee.setPassword(employee.getEmployeeBirth());
        employeeService.insertEmployee(employee);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 删除员工
     *
     * @param employeeId
     * @return
     */
    @RequestMapping(value = "employee/doDeleteEmployee/{employeeId}")
    @ResponseBody
    public Map<String, String> doDeleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 修改员工
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "employee/doUpdateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doUpdateEmployee(@RequestBody Employee employee) {
        System.out.println(employee.getEmployeeId());

        employeeService.updateEmployee(employee);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/employee/search", params = "wd")
    public String searchEmpByIdOrName(@RequestParam("wd") String searchInfo, Model model){
        List<Employee> employees = employeeService.searchEmpByIdOrName(searchInfo);
        model.addAttribute("employees", employees);
        return "basicInfo/employee/employeeManagement";
    }
}
