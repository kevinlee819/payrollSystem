package com.hust.controller.payroll;

import com.hust.beans.payroll.SalaryProject;
import com.hust.service.payroll.SalaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/25
 * @time 18:18
 **/
@Controller
@RequestMapping(value = "salary/")
public class SalaryProController {

    private SalaryProjectService salaryProjectService;

    @Autowired
    public SalaryProController(SalaryProjectService salaryProjectService){
        this.salaryProjectService = salaryProjectService;
    }

    @RequestMapping(value = "salaryPro")
    public String salaryProManagement(Model model){
        model.addAttribute("salaryPros", salaryProjectService.getAllSalaryPros());
        return "salary/salaryPro/salaryProManagement";
    }

    /**
     * 搜索
     * @param searchInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "salaryPro/search/{searchInfo}", method = RequestMethod.GET)
    public String searchPro(@PathVariable("searchInfo") String searchInfo, Model model){
        List<SalaryProject> salaryProjects = salaryProjectService.searchByNameOrType(searchInfo);
        if(salaryProjects.size() == 0){
            model.addAttribute("salaryPros", null);
        }else{
            model.addAttribute("title", "查询到关于" + searchInfo + "的信息");
            model.addAttribute("salaryPros", salaryProjects);
        }

        return "salary/salaryPro/salaryProManagement";
    }
    /**
     * 添加工资项目
     * @param salaryProject
     * @return
     * @throws IOException
     */
    @RequestMapping(value="salaryPro/doCreateSalaryPro", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doCreateDepartment(@RequestBody SalaryProject salaryProject, HttpServletResponse response) throws IOException {
        String mes = salaryProjectService.createSalaryPro(salaryProject, response);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", mes);
        return map;
    }

    /**
     * 修改工资项目
     * @param salaryProject
     * @return
     * @throws IOException
     */
    @RequestMapping(value="salaryPro/doUpdateSalaryPro", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doUpdateDepartment(@RequestBody SalaryProject salaryProject, HttpServletResponse response) throws IOException {
        String mes = salaryProjectService.updateSalaryPro(salaryProject, response);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", mes);
        return map;
    }

    /**
     * 删除工资项目
     * @return
     */
    @RequestMapping(value="salaryPro/doDeleteSalaryPro/{salaryProName}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> doDeleteDepartment(@PathVariable String salaryProName){
        salaryProjectService.deleteSalaryProByName(salaryProName);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }
}
