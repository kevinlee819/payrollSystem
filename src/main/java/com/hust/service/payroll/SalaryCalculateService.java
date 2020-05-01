package com.hust.service.payroll;

import com.hust.beans.payroll.ImportProjectInfo;
import com.hust.beans.payroll.SalaryCalculate;
import com.hust.dao.payroll.SalaryCalculateDao;
import com.hust.util.DepAndDate;
import com.hust.util.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkj
 * @date 2019/6/27
 * @time 11:45
 **/
public class SalaryCalculateService {
    @Autowired
    private SalaryCalculateDao salaryCalculateDao;

    public void setSalaryCalculateDao(SalaryCalculateDao salaryCalculateDao) {
        this.salaryCalculateDao = salaryCalculateDao;
    }

    /**
     * 通过部门名称搜索
     * @param depName
     * @return
     */
    public List<SalaryCalculate> searchSalaryByDep(String depName){
        return calculate(salaryCalculateDao.searchSalaryByDep(depName));
    }

    /**
     * 通过员工id搜索
     * @param empId
     * @return
     */
    public List<SalaryCalculate> searchSalaryById(int empId){
        return calculate(salaryCalculateDao.searchSalaryById(empId));
    }

    /**
     * 通过日期范围搜索
     * @param date
     * @return
     */
    public List<SalaryCalculate> searchSalaryByRange(Range date){
        return calculate(salaryCalculateDao.searchSalaryByRange(date));
    }
    /**
     * 病假扣款20/天、事假扣款50/天、迟到扣款10/元、加班工资100/天。
     * @param depAndDate
     * @return
     */
    public List<SalaryCalculate> searchSalaryByDepAndDate(DepAndDate depAndDate){
        List<SalaryCalculate> salaryCalculates = salaryCalculateDao.searchSalaryByDepAndDate(depAndDate);
         return calculate(salaryCalculates);
    }

    private List<SalaryCalculate> calculate(List<SalaryCalculate> salaryCalculates){
        List<SalaryCalculate> res = new ArrayList<>();
        for(SalaryCalculate salaryCalculate : salaryCalculates){
            SalaryCalculate salary = new SalaryCalculate();
            salary.setFixedSalaryPro(salaryCalculate.getFixedSalaryPro());
            salary.setImportProjectInfo(salaryCalculate.getImportProjectInfo());
            salary.setEmpId(salaryCalculate.getEmpId());
            salary.setEmpName(salaryCalculate.getEmpName());
            salary.setDepName(salaryCalculate.getDepName());
            Double fixedSalary = salaryCalculate.getFixedSalaryPro().getBasicSalary() + salaryCalculate.getFixedSalaryPro().getHeatingSubsidy();
            Double calculate = calculateImport(salaryCalculate.getImportProjectInfo());
            Double reissue = salaryCalculate.getImportProjectInfo().getReissue();
            salary.setReissue(reissue);
            Double realSalary = fixedSalary + calculate + reissue;
            if(realSalary < 0.0){
                realSalary = 0.0;
            }
            salary.setRealSalary(realSalary);
            res.add(salary);
        }
        return res;
    }

    /**
     * 发放工资
     * @param depAndDate
     */
    public int paySalary(DepAndDate depAndDate){
        //工资已经发放
        if(checkStatus(depAndDate) == 1){
            return 1;
        }else{
            salaryCalculateDao.paySalary(depAndDate);
            return 0;
        }

    }

    /**
     * 查看状态
     * @param depAndDate
     * @return
     */
    public int checkStatus(DepAndDate depAndDate){
        return salaryCalculateDao.checkStatus(depAndDate);
    }

    private Double calculateImport(ImportProjectInfo importProjectInfo){
        return importProjectInfo.getOvertimeDay() * 100.0-importProjectInfo.getSickLeaveDay() * 20.0 - importProjectInfo.getPersonalLeaveDay() * 50.0-
                importProjectInfo.getLateNum() * 10.0;
    }
}
