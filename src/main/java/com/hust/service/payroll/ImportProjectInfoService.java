package com.hust.service.payroll;

import com.hust.beans.payroll.ImportProjectInfo;
import com.hust.dao.payroll.ImportProjectInfoDao;
import com.hust.util.Number;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:56
 **/
public class ImportProjectInfoService {
    @Autowired
    private ImportProjectInfoDao importProjectInfoDao;

    public void setImportProjectInfoDao(ImportProjectInfoDao importProjectInfoDao) {
        this.importProjectInfoDao = importProjectInfoDao;
    }
    public List<ImportProjectInfo> search(String info){
        List<ImportProjectInfo> importProjectInfos = new ArrayList<>();
        if(Number.isPosNum(info)){
            importProjectInfos.addAll(searchImportProInfoById(Integer.valueOf(info)));
        }
        importProjectInfos.addAll(searchImportProInfoByDepName(info));
        for(ImportProjectInfo importProjectInfo : importProjectInfos){
            System.out.println(importProjectInfo.getEmpName());
        }
        return importProjectInfos;
    }

    /**
     * 批量导入数据，不存在则创建
     * @param response
     * @param list
     * @throws IOException
     */
    public void batchCreateImportProInfo(HttpServletResponse response, List<Map<String, String>> list) throws IOException {
        for(int i = 0; i < list.size(); i++){
            if(!Number.isPosNum(list.get(i).get("empId"))){
                response.sendError(500, "empId不是数字");
            }
            int empId = Integer.valueOf(list.get(i).get("empId"));
            String empName = list.get(i).get("empName");
            if(!Number.isPosNum(list.get(i).get("sickLeaveDay"))){
                response.sendError(500, "sickLeaveDay不是数字");
            }
            int sickLeaveDay = Integer.valueOf(list.get(i).get("sickLeaveDay"));
            if(!Number.isPosNum(list.get(i).get("personalLeaveDay"))){
                response.sendError(500, "personalLeaveDay不是数字");
            }
            Integer personalLeaveDay = Integer.valueOf(list.get(i).get("personalLeaveDay"));
            if(!Number.isPosNum(list.get(i).get("lateNum"))){
                response.sendError(500, "lateNum不是数字");
            }
            Integer lateNum = Integer.valueOf(list.get(i).get("lateNum"));
            if(!Number.isPosNum(list.get(i).get("overtimeDay"))){
                response.sendError(500, "overtimeDay不是数字");
            }
            Integer overtimeDay = Integer.valueOf(list.get(i).get("overtimeDay"));
            if(!Number.isPosNum(list.get(i).get("reissue"))){
                response.sendError(500, "reissue不是数字");
            }
            Double reissue = Double.valueOf(list.get(i).get("reissue"));
            String importDate = list.get(i).get("importDate");
            ImportProjectInfo importProjectInfo = new ImportProjectInfo(empId, empName, sickLeaveDay,
                    personalLeaveDay, lateNum, overtimeDay, reissue, importDate);
           //不存在则创建，存在则更新
            if(existsImport(importProjectInfo) == 0){
                importProjectInfoDao.createImportProInfo(importProjectInfo);
            }else{
                importProjectInfoDao.updateImportProInfo(importProjectInfo);
            }

        }
    }

    public String getCurrYearAndMonth(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        return  simpleDateFormat.format(date);
    }

    public List<String> getAllDate(){
        HashSet<String> set = new HashSet<>(importProjectInfoDao.getAllDate());
        return new ArrayList<>(set);
    }
    /**
     * 根据日期批量删除导入项目信息
     * @param date
     */
    public void deleteImportProInfoByDate(String date){
        importProjectInfoDao.deleteImportProInfoByDate(date);
    }

    /**
     * 新增导入项目
     * @param importProjectInfo
     */
    public void createImportProInfo(ImportProjectInfo importProjectInfo){
        importProjectInfoDao.createImportProInfo(importProjectInfo);
    }

    /**
     * 更新导入项目
     * @param importProjectInfo
     */
    public void updateImportProInfo(ImportProjectInfo importProjectInfo){
        importProjectInfoDao.updateImportProInfo(importProjectInfo);
    }
    /**
     * 通过员工编号搜索导入项目信息
     *
     * @param empId
     * @return
     */
    public List<ImportProjectInfo> searchImportProInfoById(int empId) {
        return importProjectInfoDao.searchImportProInfoById(empId);
    }

    /**
     * 通过部门名称搜索导入项目列表
     *
     * @param departmentName
     * @return
     */
    public List<ImportProjectInfo> searchImportProInfoByDepName(String departmentName) {
        return importProjectInfoDao.searchImportProInfoByDepName(departmentName);
    }

    /**
     * 通过日期搜索导入项目列表
     * @param date
     * @return
     */
    public List<ImportProjectInfo> searchImportProInfoByDate(String date){
        return importProjectInfoDao.searchImportProInfoByDate(date);
    }

    public int existsImport(ImportProjectInfo importProjectInfo){
        return importProjectInfoDao.existsImport(importProjectInfo);
    }
}
