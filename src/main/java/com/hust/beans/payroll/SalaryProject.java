package com.hust.beans.payroll;

/**
 * @author lkj
 * @date 2019/6/24
 * @time 9:41
 **/
public class SalaryProject {
    private Integer salaryProId;
    private String salaryProName;
    private String salaryProType;
    private String isDisplayed;
    private Integer displayOrder;
    private String incOrDec;

    public SalaryProject() {
    }

    public SalaryProject(String salaryProName, String salaryProType, String isDisplayed,
                         Integer displayOrder, String incOrDec) {
        this.salaryProName = salaryProName;
        this.salaryProType = salaryProType;
        this.isDisplayed = isDisplayed;
        this.displayOrder = displayOrder;
        this.incOrDec = incOrDec;
    }

    public Integer getSalaryProId() {
        return salaryProId;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public String getIncOrDec() {
        return incOrDec;
    }

    public String getIsDisplayed() {
        return isDisplayed;
    }

    public String getSalaryProName() {
        return salaryProName;
    }

    public String getSalaryProType() {
        return salaryProType;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public void setSalaryProName(String salaryProName) {
        this.salaryProName = salaryProName;
    }

    public void setIncOrDec(String incOrDec) {
        this.incOrDec = incOrDec;
    }

    public void setIsDisplayed(String isDisplayed) {
        this.isDisplayed = isDisplayed;
    }

    public void setSalaryProId(Integer salaryProId) {
        this.salaryProId = salaryProId;
    }

    public void setSalaryProType(String salaryProType) {
        this.salaryProType = salaryProType;
    }
}
