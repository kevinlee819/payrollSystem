package com.hust.dao;

import com.hust.beans.Employee;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/18
 * @time 15:34
 **/
public interface EmployeeDao {
    /**
     * 添加Employee
     * @param employee
     */
    void insertEmployee(Employee employee);

    /**
     * 修改Employee
     * @param employee
     */
    void updateEmployee(Employee employee);
    /**
     * 通过id获取Employee
     * @param employeeId
     * @return
     */
    Employee selectEmployeeById(Integer employeeId);

    /**
     * 通过员工名搜索员工信息
     * @param empName
     * @return
     */
    List<Employee> selectEmpByName(String empName);

    /**
     * 获取所有Employee
     * @return
     */
    List<Employee> getAllEmployees();

    /**
     * 通过id删除Employee
     * @param employeeId
     */
    void deleteEmployeeById(Integer employeeId);

    /**
     * 是否存在该员工，1表示存在
     * @param employee
     * @return
     */
    int exists(Employee employee);

    /**
     * 搜索岗位下员工
     * @param positionName
     * @return
     */
    List<Employee> searchEmpByPosName(String positionName);

    /**
     * 搜索部门员工
     * @param departmentName
     * @return
     */
    List<Employee> searchEmpByDepName(String departmentName);
}
