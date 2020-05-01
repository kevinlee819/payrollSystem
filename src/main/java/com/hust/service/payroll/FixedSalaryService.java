package com.hust.service.payroll;

import com.hust.beans.payroll.FixedSalary;
import com.hust.dao.payroll.FixedSalaryDao;
import com.hust.util.Number;
import com.hust.util.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:56
 **/
public class FixedSalaryService {
    @Autowired
    private FixedSalaryDao fixedSalaryDao;

    public void setFixedSalaryDao(FixedSalaryDao fixedSalaryDao) {
        this.fixedSalaryDao = fixedSalaryDao;
    }

    public void updateFixedSalary(FixedSalary fixedSalary) {
        fixedSalaryDao.updateFixedSalary(fixedSalary);
    }

    public List<String> getAllDeps() {
        HashSet<String> set = new HashSet<>(fixedSalaryDao.getAllDeps());
        return new ArrayList<>(set);
    }

    /**
     * 批量导入固定工资,存在则更新
     * @param list
     */
    public void batchCreateFixedSalary(List<Map<String, String>> list){
        for(int i = 0; i < list.size(); i++){
            int empId = Integer.valueOf(list.get(i).get("empId"));
            String empName = list.get(i).get("empName");
            Double basic = Double.valueOf(list.get(i).get("basicSalary"));
            Double heating = Double.valueOf(list.get(i).get("heatingSubsidy"));
            String dep = list.get(i).get("depName");
            FixedSalary fixedSalary = new FixedSalary(empId,empName, basic, heating, dep);
            //不存在该员工则创建
            if(existsEmp(empId) == 0){
                fixedSalaryDao.createFixedSalary(fixedSalary);
            }else{
                fixedSalaryDao.updateFixedSalary(fixedSalary);
            }

        }
    }
    public void createFixedSalary(FixedSalary fixedSalary) {
        fixedSalaryDao.createFixedSalary(fixedSalary);
    }

    public List<FixedSalary> searchByIdOrDep(String s) {
        List<FixedSalary> res = new ArrayList<>();
        if (Number.isPosNum(s)) {
            res.add(fixedSalaryDao.searchFixedSalaryById(Integer.valueOf(s)));
        }
        res.addAll(fixedSalaryDao.searchFixedSalaryByDep(s));
        return res;
    }


    /**
     * 通过员工Id查询固定工资
     *
     * @param empId
     * @return
     */
    public FixedSalary searchFixedSalaryById(int empId) {
        return fixedSalaryDao.searchFixedSalaryById(empId);
    }

    /**
     * 通过工资区间查询固定工资
     *
     * @param range
     * @return
     */
    public List<FixedSalary> searchFixedSalaryByRange(Range range) {
        return fixedSalaryDao.searchFixedSalaryByRange(range);
    }

    /**
     * 通过部门名搜索搜索固定工资列表
     *
     * @param departmentName
     * @return
     */
    public List<FixedSalary> searchFixedSalaryByDep(String departmentName) {
        return fixedSalaryDao.searchFixedSalaryByDep(departmentName);
    }

    public int existsEmp(int empId){
        return fixedSalaryDao.existsEmp(empId);
    }
}
