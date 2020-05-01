package com.hust.controller.payroll;

import com.hust.beans.Department;
import com.hust.service.DepartmentService;
import com.hust.service.payroll.SalaryCalculateService;
import com.hust.util.DepAndDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/27
 * @time 14:18
 **/
@Controller
@RequestMapping("salary/")
public class SalaryCalculateController {

    private SalaryCalculateService salaryCalculateService;
    private DepartmentService departmentService;

    @Autowired
    public SalaryCalculateController(SalaryCalculateService salaryCalculateService, DepartmentService departmentService){
        this.salaryCalculateService = salaryCalculateService;
        this.departmentService = departmentService;
    }

    @ModelAttribute("departments")
    public List<Department> getAllDeps(){
        return departmentService.getAllDepartments();
    }
    @RequestMapping(value = "calculatePage")
    public String calculatePage(Model model){
        DepAndDate depAndDate = new DepAndDate("研发部", "2019-06");
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryByDepAndDate(depAndDate));
        int status = salaryCalculateService.checkStatus(depAndDate);
        model.addAttribute("status", status);
        return "salary/calculate/calculateManagement";
    }

    @RequestMapping(value = "calculate", params = {"depName", "date"})
    public String calculate(Model model, @RequestParam("depName") String depName, @RequestParam("date") String date){
        DepAndDate depAndDate = new DepAndDate(depName, date);
        model.addAttribute("calculateSalary", salaryCalculateService.searchSalaryByDepAndDate(depAndDate));
        int status = salaryCalculateService.checkStatus(depAndDate);
        model.addAttribute("status", status);
        return "salary/calculate/calculateManagement";
    }

    @RequestMapping(value = "paySalary", params = {"depName", "date"},method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> paySalary(Model model, @RequestParam("depName") String depName, @RequestParam("date") String date){
        DepAndDate depAndDate = new DepAndDate(depName, date);
        int status = salaryCalculateService.paySalary(depAndDate);
        model.addAttribute("status", salaryCalculateService.checkStatus(depAndDate));
        Map<String, Integer> map = new HashMap<>(1);
        map.put("message", status);
        return map;
    }

    @RequestMapping(value = "saveSalary", params = {"depName", "date"},method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> saveSalary(Model model, @RequestParam("depName") String depName, @RequestParam("date") String date){
        DepAndDate depAndDate = new DepAndDate(depName, date);
        int status = salaryCalculateService.checkStatus(depAndDate);
        model.addAttribute("status", status);
        Map<String, Integer> map = new HashMap<>(1);
        if(status == 1){
            map.put("message", 1);
        }else{
            map.put("message", 0);
        }
        return map;
    }
}
