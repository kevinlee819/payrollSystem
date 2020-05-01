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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/20
 * @time 20:38
 **/
@Controller
@RequestMapping("basicInfo/")
public class PositionController {

    private PositionService positionService;
    private DepartmentService departmentService;

    @Autowired
    public PositionController(PositionService positionService, DepartmentService departmentService){
        this.positionService = positionService;
        this.departmentService = departmentService;
    }
    @ModelAttribute("positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @ModelAttribute("departments")
    public List<Department> getAllDeps() {
        return departmentService.getAllDepartments();
    }
    @RequestMapping("position")
    public String positionManagement(Model model){
        model.addAttribute("positions", positionService.getAllPositions());
        return "basicInfo/position/positionManagement";
    }

    /**
     * 搜索岗位下员工
     * @param searchInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "/position/search", params = "wd")
    public String searchPosEmp(@RequestParam("wd") String searchInfo, Model model){
        List<Employee> employees = positionService.searchPosEmp(searchInfo);
        if(employees.size() == 0){
            model.addAttribute("title", "没有搜索到关于"+searchInfo+"的员工信息");
        }else{
            model.addAttribute("title", "关于" + searchInfo + "的员工信息");
        }
        model.addAttribute("employees", employees);
        return "basicInfo/position/searchPosEmp";
    }

    /**
     * 增加岗位
     * @param position
     * @return
     */
    @RequestMapping(value = "position/doCreatePosition", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doCreatePosition(@RequestBody Position position){

        System.out.println(position.getPositionName());
        positionService.insertPosition(position);
        Map<String, String> map =  new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 删除岗位
     * @param positionId
     * @return
     */
    @RequestMapping(value = "position/doDeletePosition/{positionId}")
    @ResponseBody
    public Map<String, String> doDeletePosition(@PathVariable int positionId){

        positionService.deletePositionById(positionId);
        Map<String, String> map =  new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 修改岗位
     * @param position
     * @return
     */
    @RequestMapping(value = "position/doUpdatePosition", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doUpdatePosition(@RequestBody Position position){

        positionService.updatePosition(position);
        Map<String, String> map =  new HashMap<>(1);
        map.put("message", "success");
        return map;
    }
}
