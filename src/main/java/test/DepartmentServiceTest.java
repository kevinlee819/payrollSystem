package test;

import com.hust.beans.Department;
import com.hust.service.DepartmentService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/19
 * @time 15:47
 **/
public class DepartmentServiceTest {

    public DepartmentService init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        return(DepartmentService) context.getBean("departmentService");
    }
    @Test
    public void insertDepartment() {
        DepartmentService departmentService = init();
        Date date = new Date();
        Department department = new Department("研发部", "部门", "110", "2019-10-09");
         departmentService.insertDepartment(department);
        System.out.println(date);
    }

    @Test
    public void deleteDepartmentById() {
        DepartmentService departmentService = init();
        departmentService.deleteDepartmentById(6);
    }

    @Test
    public void updateDepartment() {
        DepartmentService departmentService = init();
        Date date = new Date();
        Department department = new Department("研发部", "部门", "110", "2019-10-09");
        department.setDepartmentId(1);
        departmentService.updateDepartment(department);
    }
    @Test
    public void getAllDepartments(){
        DepartmentService departmentService = init();
        List<Department> departments = departmentService.getAllDepartments();
        for(Department department : departments){
            System.out.println(department.getDepartmentId());
        }
    }
}