package com.hust.controller;

import com.hust.beans.Department;
import com.hust.beans.Employee;
import com.hust.beans.Position;
import com.hust.service.DepartmentService;
import com.hust.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/19
 * @time 20:11
 **/

@Controller
@RequestMapping("/basicInfo")
public class DepartmentController {

    private DepartmentService departmentService;
    private PositionService positionService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, PositionService positionService){
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @ModelAttribute("positions")
    public List<Position> getAllPoss() {
        return  positionService.getAllPositions();
    }
    @ModelAttribute(value = "departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
    @RequestMapping(value = "/department")
    public String departmentManagement(){
        return "basicInfo/department/departmentManagement";
    }
    @RequestMapping(value = "/department/createDepartment")
    public String createDepartment(){
        return "basicInfo/department/createDepartment";
    }


    @RequestMapping(value = "/department/search", params = "wd")
    public String searchDepEmp(@RequestParam("wd") String searchInfo, Model model){
        List<Employee> employees = departmentService.searchDepEmp(searchInfo);
        model.addAttribute("employees", employees);
        if(employees.size() == 0){
            model.addAttribute("title", "没有搜索到关于"+searchInfo+"的员工信息");
        }else{
            model.addAttribute("title", "关于" + searchInfo + "的员工信息");
        }

        return "basicInfo/department/searchDepEmp";
    }
    /**
     * 添加部门
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="department/doCreateDepartment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> doCreateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        departmentService.insertDepartment(request, response);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 修改部门
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="department/doUpdateDepartment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> doUpdateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        departmentService.updateDepartment(request, response);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 删除部门
     * @return
     */
    @RequestMapping(value="department/doDeleteDepartment/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> doDeleteDepartment(@PathVariable int departmentId){
        departmentService.deleteDepartmentById(departmentId);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }
}
