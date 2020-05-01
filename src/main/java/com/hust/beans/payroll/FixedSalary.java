package com.hust.beans.payroll;

/**
 * @author 李科锦
 * @date 2019/6/24
 * @time 9:41
 **/
public class FixedSalary {
    private Integer empId;
    private String empName;
    private Double basicSalary;
    private Double heatingSubsidy;
    private String depName;

    public FixedSalary(){}

    public FixedSalary(Integer empId, String empName, Double basicSalary, Double heatingSubsidy, String depName){
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
        this.heatingSubsidy = heatingSubsidy;
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public String getEmpName() {
        return empName;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public Double getHeatingSubsidy() {
        return heatingSubsidy;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setHeatingSubsidy(Double heatingSubsidy) {
        this.heatingSubsidy = heatingSubsidy;
    }
}
