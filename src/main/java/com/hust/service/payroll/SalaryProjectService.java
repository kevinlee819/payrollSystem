package com.hust.service.payroll;

import com.hust.beans.payroll.SalaryProject;
import com.hust.dao.payroll.SalaryProjectDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:56
 **/
public class SalaryProjectService {
    @Autowired
    private SalaryProjectDao salaryProjectDao;

    private static final String SUCCESS_CREATE = "200";

    private static final String SUCCESS_UPDATE = "200";

    private static final String ERROR1 = "工资项目名称不能相同";

    private static final String ERROR2 = "发类型项目只能有一个";

    private static final String REAL_PROJECT = "实发项目";

    public void setSalaryProjectDao(SalaryProjectDao salaryProjectDao) {
        this.salaryProjectDao = salaryProjectDao;
    }
    /**
     * 获取所有工资项目
     * @return
     */
    public List<SalaryProject> getAllSalaryPros(){
        return salaryProjectDao.getAllSalaryPros();
    }
    /**
     * 通过id查询工资项目
     *
     * @param salaryProId
     * @return
     */
    public SalaryProject searchSalaryProById(int salaryProId) {
        return salaryProjectDao.searchSalaryProById(salaryProId);
    }

    /**
     * 增加工资项目
     * 约束：1、工资项目名称不能相同。
     * 2、实发类型项目只能有一个。
     *
     * @param salaryProject
     */
    public String createSalaryPro(SalaryProject salaryProject, HttpServletResponse response) throws IOException {
        if (existThisName(salaryProject.getSalaryProName())) {
            //response.sendError(500, ERROR1);
            return ERROR1;
        }
        if (existRealPro(salaryProject)) {
            //response.sendError(500, ERROR2);
            return ERROR2;
        }
        salaryProjectDao.createSalaryPro(salaryProject);
        return SUCCESS_CREATE;
    }
    public String createSalaryPro(SalaryProject salaryProject)  {
        if (existThisName(salaryProject.getSalaryProName())) {
            return ERROR1;
        }
        if (existRealPro(salaryProject)) {
            return ERROR2;
        }
        salaryProjectDao.createSalaryPro(salaryProject);
        return SUCCESS_CREATE;
    }
    /**
     * 通过项目名称删除工资项目
     *
     * @param salaryProName
     */
    public void deleteSalaryProByName(String salaryProName) {
        salaryProjectDao.deleteSalaryProByName(salaryProName);
    }

    /**
     * 更新工资项目
     * 约束：1、工资项目名称不能相同。
     * 2、实发类型项目只能有一个。
     *
     * @param salaryProject
     */
    public String updateSalaryPro(SalaryProject salaryProject, HttpServletResponse response) throws IOException {
        if (isChangedProName(salaryProject) && existThisName(salaryProject.getSalaryProName())) {
            //response.sendError(500, ERROR1);
            return ERROR1;
        }
        if (isChangedProType(salaryProject) && existRealPro(salaryProject)) {
           // response.sendError(500, ERROR2);
            return ERROR2;
        }
        salaryProjectDao.updateSalaryPro(salaryProject);
        return SUCCESS_UPDATE;
    }
    public String updateSalaryPro(SalaryProject salaryProject){
        if (isChangedProName(salaryProject) && existThisName(salaryProject.getSalaryProName())) {
            return ERROR1;
        }
        if (isChangedProType(salaryProject) && existRealPro(salaryProject)) {
            return ERROR2;
        }
        salaryProjectDao.updateSalaryPro(salaryProject);
        return SUCCESS_UPDATE;
    }

    /**
     * 项目名称是否改变
     * @param salaryProject
     * @return
     */
    private boolean isChangedProName(SalaryProject salaryProject){
        return !searchSalaryProById(salaryProject.getSalaryProId()).getSalaryProName().equals(salaryProject.getSalaryProName());
    }

    /**
     * 项目类型是否改变
     * @param salaryProject
     * @return
     */
    private boolean isChangedProType(SalaryProject salaryProject){
        return !searchSalaryProById(salaryProject.getSalaryProId()).getSalaryProType().equals(salaryProject.getSalaryProType());
    }
    private boolean existThisName(String salaryProName) {
        return salaryProjectDao.existThisName(salaryProName) == 1;
    }

    private boolean existRealPro(SalaryProject salaryProject) {
        return salaryProject.getSalaryProType().equals(REAL_PROJECT) && salaryProjectDao.existRealPro() == 1;
    }

    /**
     * 通过名称或者类型查询工资项目
     *
     * @param nameOrType
     * @return
     */
    public List<SalaryProject> searchByNameOrType(String nameOrType) {
        return salaryProjectDao.searchByNameOrType(nameOrType);
    }
}
