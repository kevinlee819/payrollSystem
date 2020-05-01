package test;

import com.hust.beans.payroll.SalaryCalculate;
import com.hust.service.payroll.SalaryCalculateService;
import com.hust.util.DepAndDate;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/27
 * @time 13:18
 **/
public class SalaryCalculateServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    SalaryCalculateService salaryCalculateService = (SalaryCalculateService)context.getBean("salaryCalculateService");
    @Test
    public void searchSalaryByDepAndDate() {
        DepAndDate depAndDate = new DepAndDate("研发部", "2019-06");
        List<SalaryCalculate> salaryCalculates = salaryCalculateService.searchSalaryByDepAndDate(depAndDate);
        System.out.println(salaryCalculates.get(0).getEmpId());
        System.out.println(salaryCalculates.get(0).getEmpName());
        System.out.println(salaryCalculates.size());
    }

    @Test
    public void searchSalaryByDep() {
        List<SalaryCalculate> salaryCalculates = salaryCalculateService.searchSalaryByDep("研发部");
        System.out.println(salaryCalculates.get(0).getEmpName());
    }

    @Test
    public void searchSalaryById() {
    }

    @Test
    public void searchSalaryByRange() {
    }
}