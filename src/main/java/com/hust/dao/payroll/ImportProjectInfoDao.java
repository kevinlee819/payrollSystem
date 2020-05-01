package com.hust.dao.payroll;

import com.hust.beans.payroll.ImportProjectInfo;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 10:54
 **/
public interface ImportProjectInfoDao {
    /**
     * 获取所有导入日期
     * @return
     */
    List<String> getAllDate();
    /**
     * 根据日期批量删除导入项目信息
     * @param importDate
     */
     void deleteImportProInfoByDate(String importDate);

    /**
     * 新增导入项目
     * @param importProjectInfo
     */
     void createImportProInfo(ImportProjectInfo importProjectInfo);

    /**
     * 更新导入项目
     * @param importProjectInfo
     */
    void updateImportProInfo(ImportProjectInfo importProjectInfo);
    /**
     * 通过员工编号搜索导入项目信息
     * @param empId
     * @return
     */
    List<ImportProjectInfo> searchImportProInfoById(int empId);

    /**
     * 通过部门名称搜索导入项目列表
     * @param departmentName
     * @return
     */
    List<ImportProjectInfo> searchImportProInfoByDepName(String departmentName);

    /**
     * 通过日期搜索导入项目列表
     * @param date
     * @return
     */
    List<ImportProjectInfo> searchImportProInfoByDate(String date);

    /**
     * 根据导入日期和员工Id判断是否存在导入信息，1表示存在，0不存在
     * @param importProjectInfo
     * @return
     */
    int existsImport(ImportProjectInfo importProjectInfo);
}
