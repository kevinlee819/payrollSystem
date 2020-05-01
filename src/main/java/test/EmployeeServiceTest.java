package test;

import com.hust.beans.Employee;
import com.hust.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 宁鑫
 * @date 2019/6/18
 * @time 16:31
 **/
public class EmployeeServiceTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");
    Employee employee = new Employee("宁鑫", "男",
            "1998-10-09", "23819024701740", "研发部",
            "专业搬砖户", "2019-10-11", "2010-10-10",
            "正式员工",  "校园招聘");
    @After
    public void tearDown() throws Exception {
    }
    @Before
    public void init(){

    }

    @Test
    public void createEmployee() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");
        Employee employee = new Employee("宁鑫", "男",
                "1998-10-09", "23819024701740", "研发部",
                "专业搬砖户", "2019-10-11", "2010-10-10",
                "正式员工",  "校园招聘");
        employee.setPassword("1111");
        employee.setPriority(1);
        for(int i = 0; i < 20; i++){
            employeeService.insertEmployee(employee);
        }

    }

    @Test
    public void exitsTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");
        assertEquals(1, employeeService.exists(1, "1234"));
        assertEquals(0, employeeService.exists(1, "123"));
    }

    @Test
    public void searchEmpByPosName() {
        List<Employee> employees = employeeService.searchEmpByPosName("专业搬砖户");
        System.out.println(employees.size());
        for(Employee employee : employees){
            System.out.println(employee.getEmployeeId());
        }
    }

    @Test
    public void searchEmpByDepName() {
    }
}