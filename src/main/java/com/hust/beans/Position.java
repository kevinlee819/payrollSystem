package com.hust.beans;

/**
 * @author lkj
 * @date 2019/6/20
 * @time 16:30
 **/
public class Position {
    private Integer positionId;
    private String positionName;
    private String positionType;
    private Integer employeeNum;

    public Position(Integer positionId, String positionName, String positionType, Integer employeeNum){
        this.positionId = positionId;
        this.positionName = positionName;
        this.positionType = positionType;
        this.employeeNum = employeeNum;
    }
    public Position(String positionName, String positionType, Integer employeeNum){
        this.positionName = positionName;
        this.positionType = positionType;
        this.employeeNum = employeeNum;
    }
    public Position(){}
    public Integer getPositionId() {
        return positionId;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
