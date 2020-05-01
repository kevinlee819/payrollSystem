package com.hust.dao.payroll;

import com.hust.beans.payroll.SalaryCalculate;
import com.hust.util.DepAndDate;
import com.hust.util.Range;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/27
 * @time 11:34
 **/
public interface SalaryCalculateDao {

    /**
     * 通过部门名称搜索
     * @param depName
     * @return
     */
    List<SalaryCalculate> searchSalaryByDep(String depName);

    /**
     * 通过员工id搜索
     * @param empId
     * @return
     */
    List<SalaryCalculate> searchSalaryById(int empId);

    /**
     * 通过日期范围搜索
     * @param date
     * @return
     */
    List<SalaryCalculate> searchSalaryByRange(Range date);

    /**
     * 通过部门和日期搜索工资
     * @return
     */
    List<SalaryCalculate> searchSalaryByDepAndDate(DepAndDate depAndDate);

    /**
     * 发放工资
     * @param depAndDate
     */
    void paySalary(DepAndDate depAndDate);

    /**
     * 查看状态
     * @param depAndDate
     * @return
     */
    int checkStatus(DepAndDate depAndDate);
}
