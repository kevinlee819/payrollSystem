package com.hust.dao;

import com.hust.beans.Department;
import com.hust.beans.Employee;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/19
 * @time 15:12
 **/
public interface DepartmentDao {
    /**
     * 通过编号、名称、类型搜索部门下员工
     */
    List<Employee> searchDepEmpById(int depId);
    List<Employee> searchDepEmpByType(String depType);
    List<Employee> searchDepEmpByName(String depName);
    /**
     * 添加部门
     * @param department
     */
    void insertDepartment(Department department);

    /**
     * 删除部门
     * @param id
     */
    void deleteDepartmentById(Integer id);

    /**
     * 更新部门信息
     * @param department
     */
    void updateDepartment(Department department);

    /**
     * 获取所有部门信息
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 通过部门名称或类型搜索岗位列表
     * @param s
     * @return
     */
    List<Department> searchDepListByNameOrType(String s);

    /**
     * 通过id搜索部门
     * @param departmentId
     * @return
     */
    Department searchDepById(int departmentId);
}
