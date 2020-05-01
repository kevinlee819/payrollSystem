package com.hust.controller.form;

import com.hust.beans.Department;
import com.hust.service.DepartmentService;
import com.hust.service.payroll.SalaryCalculateService;
import com.hust.util.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 宁鑫
 * @date 2019/6/27
 * @time 22:42
 **/
@Controller
@RequestMapping("form")
public class FormController {
    private SalaryCalculateService salaryCalculateService;
    private DepartmentService departmentService;

    @Autowired
    public FormController(SalaryCalculateService salaryCalculateService, DepartmentService departmentService){
        this.salaryCalculateService = salaryCalculateService;
        this.departmentService = departmentService;
    }

    @ModelAttribute("departments")
    public List<Department> getAllDeps(){
        return departmentService.getAllDepartments();
    }

    @RequestMapping("/formManagement")
    public String formManagement(Model model) {
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryByDep("研发部"));
        model.addAttribute("title","研发部工资报表");
        return "form/formManagement";
    }
    @RequestMapping(value = "/search", params = "depName")
    public String formSearchByDep(@RequestParam("depName") String depName, Model model){
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryByDep(depName));
        model.addAttribute("title",depName + "工资报表");
        return "form/formManagement";
    }

    @RequestMapping(value = "/search", params = "empId")
    public String formSearchById(@RequestParam("empId") int empId, Model model){
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryById(empId));
        model.addAttribute("title","员工" + empId +"工资报表");
        return "form/formManagement";
    }

    @RequestMapping(value = "/search", params = {"startDate", "endDate"})
    public String formSearchByRange(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model){
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryByRange(new Range(startDate, endDate)));
        model.addAttribute("title",startDate + "-" + endDate +"工资报表");
        return "form/formManagement";
    }
}
