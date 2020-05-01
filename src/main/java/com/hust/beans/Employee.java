package com.hust.beans;

/**
 * @author lkj
 * @date 2019/6/18
 * @time 14:22
 **/
public class Employee {
    private String employeeName;
    private Integer employeeId;
    private String employeeSex;
    private String employeeBirth;
    private String IdNumber;
    private String departmentName;
    private String positionName;
    /**
     * 入职日期
     */
    private String dateOfEntry;
    /**
     * 参加工作日期
     */
    private String dateOfParti;
    private String formOfEmployment;
    private String sourceOfEmployment;

    private String password;
    private Integer priority;


    public Employee() {
    }

    public Employee(String employeeName, String password, Integer priority) {
        this.employeeName = employeeName;
        this.password = password;
        this.priority = priority;
    }

    public Employee(String employeeName, String employeeSex,
                    String employeeBirth, String IdNumber, String departmentName,
                    String positionName, String dateOfEntry, String dateOfParti,
                    String formOfEmployment, String sourceOfEmployment) {
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.employeeBirth = employeeBirth;
        this.IdNumber = IdNumber;
        this.departmentName = departmentName;
        this.positionName = positionName;
        this.dateOfEntry = dateOfEntry;
        this.dateOfParti = dateOfParti;
        this.formOfEmployment = formOfEmployment;
        this.sourceOfEmployment = sourceOfEmployment;

    }

    public Employee(Integer employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getEmployeeBirth() {
        return employeeBirth;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public String getDateOfParti() {
        return dateOfParti;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public String getSourceOfEmployment() {
        return sourceOfEmployment;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployeeBirth(String employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public void setDateOfParti(String dateOfParti) {
        this.dateOfParti = dateOfParti;
    }

    public void setFormOfEmployment(String formOfEmployment) {
        this.formOfEmployment = formOfEmployment;
    }

    public void setSourceOfEmployment(String sourceOfEmployment) {
        this.sourceOfEmployment = sourceOfEmployment;
    }


    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
