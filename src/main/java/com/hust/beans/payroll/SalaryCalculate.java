package com.hust.beans.payroll;

/**
 * @author lkj
 * @date 2019/6/27
 * @time 11:24
 **/
public class SalaryCalculate {
    private String depName;
    private Integer empId;
    private String empName;
    private Double realSalary;
    private Double sickCharge;
    private Double personalCharge;
    private Double lateCharge;
    private Double overtimeSalary;
    private String date;
    private ImportProjectInfo importProjectInfo;
    private FixedSalary fixedSalaryPro;

    /**
     * 状态，0表示处于暂存状态，1表示已经发放
     */
    private int status;


    private Double fixedSalary;
    private Double reissue;
    private Double calSalary;

    public SalaryCalculate(){}

    public String getDate() {
        if(importProjectInfo != null){
            return importProjectInfo.getImportDate();
        }else{
            return date;
        }
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SalaryCalculate(ImportProjectInfo importProjectInfo, FixedSalary fixedSalaryPro){
        this.importProjectInfo = importProjectInfo;
        this.fixedSalaryPro = fixedSalaryPro;
    }

    public int getStatus() {
        return status;
    }

    public String getDepName() {
        return depName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getLateCharge() {
        if(importProjectInfo != null){
            return importProjectInfo.getLateNum() * 10.0;
        }else{
            return this.lateCharge;
        }

    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Double getOvertimeSalary() {
        if(importProjectInfo != null) {
            return importProjectInfo.getOvertimeDay() * 100.0;
        }else{
            return this.overtimeSalary;
        }
    }

    public Double getPersonalCharge() {
        if(importProjectInfo != null) {
            return importProjectInfo.getPersonalLeaveDay() * 50.0;
        }else{
            return this.personalCharge;
        }
    }

    public Double getSickCharge() {
        if(importProjectInfo != null) {
            return importProjectInfo.getSickLeaveDay() * 20.0;
        }else{
            return this.sickCharge;
        }
    }

    public Double getReissue() {
        return reissue;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Double getRealSalary() {
        return realSalary;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public Double getCalSalary() {
        return calSalary;
    }

    public ImportProjectInfo getImportProjectInfo() {
        return importProjectInfo;
    }

    public FixedSalary getFixedSalaryPro() {
        return fixedSalaryPro;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setRealSalary(Double realSalary) {
        this.realSalary = realSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public void setPersonalCharge(Double personalCharge) {
        this.personalCharge = personalCharge;
    }

    public void setLateCharge(Double lateCharge) {
        this.lateCharge = lateCharge;
    }

    public void setSickCharge(Double sickCharge) {
        this.sickCharge = sickCharge;
    }

    public void setOvertimeSalary(Double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public void setReissue(Double reissue) {
        this.reissue = reissue;
    }

    public void setCalSalary(Double calSalary) {
        this.calSalary = calSalary;
    }

    public void setImportProjectInfo(ImportProjectInfo importProjectInfo) {
        this.importProjectInfo = importProjectInfo;
    }

    public void setFixedSalaryPro(FixedSalary fixedSalaryPro) {
        this.fixedSalaryPro = fixedSalaryPro;
    }
}
