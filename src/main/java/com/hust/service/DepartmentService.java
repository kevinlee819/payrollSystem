package com.hust.service;

import com.hust.beans.Department;
import com.hust.beans.Employee;
import com.hust.dao.DepartmentDao;
import com.hust.util.Number;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lkj
 * @date 2019/6/19
 * @time 15:12
 **/
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    public void insertDepartment(Department department) {
        departmentDao.insertDepartment(department);
    }

    public void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Department department = getDepartment(request, response);
        department.setStartDate(request.getParameter("startDate"));
        insertDepartment(department);
    }

    public Department searchDepById(int departmentId) {
        return departmentDao.searchDepById(departmentId);
    }

    public List<Department> searchDepListByNameOrType(String s) {
        return departmentDao.searchDepListByNameOrType(s);
    }

    public List<Employee> searchDepEmp(String searchInfo){
        List<Employee> employees = new ArrayList<>();
        if(Number.isPosNum(searchInfo)){
            employees.addAll(departmentDao.searchDepEmpById(Integer.valueOf(searchInfo)));
        }
        employees.addAll(departmentDao.searchDepEmpByName(searchInfo));
        employees.addAll(departmentDao.searchDepEmpByType(searchInfo));
        return employees;
    }

    /**
     * 删除部门
     *
     * @param id
     */
    public void deleteDepartmentById(Integer id) {
        departmentDao.deleteDepartmentById(id);
    }

    /**
     * 更新部门信息
     *
     * @param department
     */
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Department department = getDepartment(request, response);
        department.setDepartmentId(Integer.valueOf(request.getParameter("departmentId")));
        updateDepartment(department);
    }

    private Department getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String departmentName = request.getParameter("departmentName");
        String departmentTel = request.getParameter("departmentTel");
        String departmentType = request.getParameter("departmentType");
        return new Department(departmentName, departmentType, departmentTel);
    }
}
