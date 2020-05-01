package com.hust.beans;

import java.util.Date;
import java.util.List;

/**
 * @author lkj
 * @date 2019/6/19
 * @time 15:02
 **/
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String departmentType;
    private String departmentTel;
    private  String startDate;
    public Department(Integer departmentId, String departmentName, String departmentType, String departmentTel, String startDate){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentType = departmentType;
        this.departmentTel = departmentTel;
        this.startDate = startDate;
    }
    public Department(String departmentName, String departmentType, String departmentTel, String startDate){
        this.departmentName = departmentName;
        this.departmentType = departmentType;
        this.departmentTel = departmentTel;
        this.startDate = startDate;
    }
    public Department(String departmentName, String departmentType, String departmentTel){
        this.departmentName = departmentName;
        this.departmentType = departmentType;
        this.departmentTel = departmentTel;
    }

    public String getStartDate() {
        return startDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentTel() {
        return departmentTel;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentTel(String departmentTel) {
        this.departmentTel = departmentTel;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
