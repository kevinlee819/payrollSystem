package com.hust.service;

import com.hust.beans.Employee;
import com.hust.dao.EmployeeDao;
import com.hust.util.Number;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkj
 * @date 2019/6/18
 * @time 15:57
 **/
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    /**
     * 通过员工Id或者名字搜索员工信息
     * @param search
     * @return
     */
    public List<Employee> searchEmpByIdOrName(String search) {
        List<Employee> employees = new ArrayList<>();
        if(Number.isPosNum(search)){
            employees.add(selectEmployeeById(Integer.valueOf(search)));
        }
        employees.addAll(selectEmpByName(search));
        return employees;
    }

    public Employee selectEmployeeById(Integer employeeId) {
        return employeeDao.selectEmployeeById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployeeById(Integer employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }

    public int exists(int employeeId, String password) {
        return employeeDao.exists(new Employee(employeeId, password));
    }

    public List<Employee> selectEmpByName(String empName) {
        return employeeDao.selectEmpByName(empName);
    }

    /**
     * 搜索岗位下员工
     *
     * @param positionName
     * @return
     */
    public List<Employee> searchEmpByPosName(String positionName) {
        return employeeDao.searchEmpByPosName(positionName);
    }

    /**
     * 搜索部门员工
     *
     * @param departmentName
     * @return
     */
    public List<Employee> searchEmpByDepName(String departmentName) {
        return employeeDao.searchEmpByDepName(departmentName);

    }
}
