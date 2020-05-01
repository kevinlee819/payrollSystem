package com.hust.dao.payroll;

import com.hust.beans.payroll.FixedSalary;
import com.hust.util.Range;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:54
 **/
public interface FixedSalaryDao {

    void updateFixedSalary(FixedSalary fixedSalary);

    void createFixedSalary(FixedSalary fixedSalary);

    List<String> getAllDeps();

    /**
     * 通过员工Id查询固定工资
     * @param empId
     * @return
     */
    FixedSalary searchFixedSalaryById(int empId);

    /**
     * 通过工资区间查询固定工资
     * @param range
     * @return
     */
    List<FixedSalary> searchFixedSalaryByRange(Range range);

    /**
     * 通过部门名称搜索固定工资列表
     * @param departmentName
     * @return
     */
    List<FixedSalary> searchFixedSalaryByDep(String departmentName);

    /**
     * 是否存在该员工的固定工资信息
     * @param empId
     * @return
     */
    int existsEmp(int empId);

}
