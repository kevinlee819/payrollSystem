package test;

import com.hust.beans.payroll.SalaryProject;
import com.hust.service.payroll.FixedSalaryService;
import com.hust.service.payroll.SalaryProjectService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/24
 * @time 15:47
 **/
public class SalaryProjectServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

     SalaryProjectService salaryProjectService = (SalaryProjectService) context.getBean("salaryProjectService");
    @Test
    public void createSalaryPro() {
        SalaryProject salaryProject = new SalaryProject("基本工资", "固定工资项目", "是", 1, "增加");
        for(int i = 1; i < 10; i++){
            salaryProject.setDisplayOrder(i + 1);
            System.out.println(salaryProjectService.createSalaryPro(salaryProject));
        }

    }

    @Test
    public void deleteSalaryProByName() {

    }

    @Test
    public void updateSalaryPro() {
        SalaryProject salaryProject = new SalaryProject("基本工资", "固定工资项目", "否", 1, "增加");
        salaryProject.setSalaryProId(1);
        System.out.println(salaryProjectService.updateSalaryPro(salaryProject));
    }

    @Test
    public void searchByNameOrType() {
        List<SalaryProject> salaryProjects = salaryProjectService.searchByNameOrType("基本工资");
        for(SalaryProject salaryProject : salaryProjects){
            System.out.println(salaryProject.getDisplayOrder());
        }
    }
}