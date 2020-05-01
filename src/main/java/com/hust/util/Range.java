package com.hust.util;

/**
 * @author 宁鑫
 * @date 2019/6/24
 * @time 14:57
 **/
public class Range {
    private Double min;
    private Double max;

    private String startDate;
    private String endDate;

    public Range(){}

    public Range(Double min, Double max){
        this.min = min;
        this.max = max;
    }
    public Range(String startDate, String endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public void setMin(Double min) {
        this.min = min;
    }
}
