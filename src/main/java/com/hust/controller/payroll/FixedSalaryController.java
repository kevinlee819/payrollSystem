package com.hust.controller.payroll;

import com.hust.beans.payroll.FixedSalary;
import com.hust.service.payroll.FixedSalaryService;
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
 * @date 2019/6/26
 * @time 22:33
 **/
@Controller
@RequestMapping("/salary")
public class FixedSalaryController {

    private FixedSalaryService fixedSalaryService;
    @Autowired
    public FixedSalaryController(FixedSalaryService fixedSalaryService){
        this.fixedSalaryService = fixedSalaryService;
    }
    @RequestMapping(value = "/fixedSalary")
    public String importFixedPage(Model model) {
        model.addAttribute("departments", fixedSalaryService.getAllDeps());
        return "salary/fixedSalaryPro/fixedSalaryManagement";
    }

    /**
     * 通过部门名或者员工名搜索
     * @param searchInfo
     * @return
     */
    @RequestMapping(value = "/fixedSalary/search", params = "wd")
    public String searchPro(@RequestParam("wd") String searchInfo, Model model){
        System.out.println(searchInfo);
        List<FixedSalary> infos = fixedSalaryService.searchByIdOrDep(searchInfo);
        model.addAttribute("searchPros", infos);
        return "salary/fixedSalaryPro/searchFixed";
    }

    /**
     * 查看部门
     * @param dep
     * @param model
     * @return
     */
    @RequestMapping(value = "/fixedSalary/check",params = "wd")
    public String checkFixedPro(@RequestParam("wd") String dep, Model model) {
        model.addAttribute("fixedSalary", fixedSalaryService.searchFixedSalaryByDep(dep));
        return "salary/fixedSalaryPro/fixedSalaryManagement";
    }

    /**
     * 批量导入数据
     *
     * @param response
     * @param list
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/fixedSalary/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> importExcelFile(HttpServletResponse response, @RequestBody List<Map<String, String>> list) throws IOException {
        fixedSalaryService.batchCreateFixedSalary(list);
        Map<String, String> res = new HashMap<>(1);
        res.put("message", "success");
        return res;
    }

    /**
     * 修改导入项目
     * @param fixedSalary
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/fixedSalary/doUpdateFixedPro", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doUpdateFixedPro(@RequestBody FixedSalary fixedSalary, HttpServletResponse response) throws IOException {
        fixedSalaryService.updateFixedSalary(fixedSalary);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

}
