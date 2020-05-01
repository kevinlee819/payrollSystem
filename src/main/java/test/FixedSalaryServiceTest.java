package test;

import com.hust.beans.payroll.FixedSalary;
import com.hust.service.payroll.FixedSalaryService;
import com.hust.util.Range;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/24
 * @time 15:45
 **/
public class FixedSalaryServiceTest {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    FixedSalaryService fixedSalaryService = (FixedSalaryService) context.getBean("fixedSalaryService");
    @Test
    public void searchFixedSalaryById() {
    }

    @Test
    public void searchFixedSalaryByRange() {
        Range range = new Range(0.9, 10000000.0);
        List<FixedSalary> fixedSalaryList = fixedSalaryService.searchFixedSalaryByRange(range);
        for(FixedSalary fixedSalary : fixedSalaryList){
            System.out.println(fixedSalary.getBasicSalary());
        }
    }

    @Test
    public void searchFixedSalaryByDep() {
    }
}