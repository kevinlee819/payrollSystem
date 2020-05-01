package test;

import com.hust.beans.payroll.ImportProjectInfo;
import com.hust.service.payroll.FixedSalaryService;
import com.hust.service.payroll.ImportProjectInfoService;
import com.hust.util.Number;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/24
 * @time 16:27
 **/
public class ImportProjectInfoServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    ImportProjectInfoService importProjectInfoService = (ImportProjectInfoService)context.getBean("importProjectInfoService");
    @Test
    public void searchImportProInfoById() {
    }

    @Test
    public void searchImportProInfoByDepName() {
        List<ImportProjectInfo> importProjectInfoList = importProjectInfoService.searchImportProInfoByDepName("7");
        for(ImportProjectInfo importProjectInfo : importProjectInfoList){
            System.out.println(importProjectInfo.getEmpName());
        }
    }

    @Test
    public void getCurrYearAndMonth() {
        System.out.println(importProjectInfoService.getCurrYearAndMonth());
    }
    @Test
    public void isNum(){
        assertTrue(Number.isPosNum("0"));
        assertTrue(!Number.isPosNum("-11.32f"));
        assertTrue(Number.isPosNum("4"));
    }
}