package com.hust.dao.payroll;

import com.hust.beans.payroll.SalaryProject;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:55
 **/
public interface SalaryProjectDao {
    /**
     * 获取所有工资项目
     * @return
     */
    List<SalaryProject> getAllSalaryPros();
    /**
     * 通过id查询工资项目
     * @param salaryProId
     * @return
     */
    SalaryProject searchSalaryProById(int salaryProId);
    /**
     * 增加工资项目
     * @param salaryProject
     */
    void createSalaryPro(SalaryProject salaryProject);

    /**
     * 通过项目名称删除工资项目
     * @param salaryProName
     */
    void deleteSalaryProByName(String salaryProName);

    /**
     * 更新工资项目
     * @param salaryProject
     */
    void updateSalaryPro(SalaryProject salaryProject);

    /**
     * 通过名称或者类型查询工资项目
     * @param nameOrType
     * @return
     */
    List<SalaryProject> searchByNameOrType(String nameOrType);

    /**
     * 判断项目名称是否已经存在
     * @param salaryProName
     * @return
     */
    int existThisName(String salaryProName);

    /**
     * 判断是否已经存在实发项目
     *
     * @return
     */

    int existRealPro();
}
