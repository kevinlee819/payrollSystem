package com.hust.beans.payroll;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 9:42
 **/
public class ImportProjectInfo {
    private Integer empId;
    private String empName;
    private Integer sickLeaveDay;
    private Integer personalLeaveDay;
    private Integer lateNum;
    private Integer overtimeDay;
    private Double reissue;
    private String importDate;

    public ImportProjectInfo(){}

    public ImportProjectInfo(Integer empId, String empName, Integer sickLeaveDay,
                             Integer personalLeaveDay, Integer lateNum, Integer overtimeDay, Double reissue, String importDate){

        this.empId = empId;
        this.empName = empName;
        this.sickLeaveDay = sickLeaveDay;
        this.personalLeaveDay = personalLeaveDay;
        this.lateNum = lateNum;
        this.overtimeDay = overtimeDay;
        this.reissue = reissue;
        this.importDate = importDate;
    }

    public String getImportDate() {
        return importDate;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Double getReissue() {
        return reissue;
    }

    public Integer getLateNum() {
        return lateNum;
    }

    public Integer getOvertimeDay() {
        return overtimeDay;
    }

    public Integer getPersonalLeaveDay() {
        return personalLeaveDay;
    }

    public Integer getSickLeaveDay() {
        return sickLeaveDay;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setLateNum(Integer lateNum) {
        this.lateNum = lateNum;
    }

    public void setOvertimeDay(Integer overtimeDay) {
        this.overtimeDay = overtimeDay;
    }

    public void setPersonalLeaveDay(Integer personalLeaveDay) {
        this.personalLeaveDay = personalLeaveDay;
    }

    public void setReissue(Double reissue) {
        this.reissue = reissue;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public void setSickLeaveDay(Integer sickLeaveDay) {
        this.sickLeaveDay = sickLeaveDay;
    }
}
