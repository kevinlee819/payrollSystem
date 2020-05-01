package com.hust.util;

/**
 * @author 宁鑫
 * @date 2019/6/27
 * @time 11:36
 **/
public class DepAndDate {
    private String depName;
    private String date;
    public DepAndDate(){}
    public DepAndDate(String depName, String  date){
        this.depName = depName;
        this.date = date;
    }

    public String getDepName() {
        return depName;
    }

    public String getDate() {
        return date;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
