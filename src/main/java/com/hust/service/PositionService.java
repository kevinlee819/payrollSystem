package com.hust.service;

import com.hust.beans.Employee;
import com.hust.beans.Position;
import com.hust.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lkj
 * @date 2019/6/20
 * @time 16:51
 **/
public class PositionService {

    @Autowired
    private PositionDao positionDao;

    private static final Pattern PATTERN = Pattern.compile("[0-9]+");

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public List<Position> searchPosListByNameOrType(String s) {
        return positionDao.searchPosListByNameOrType(s);
    }

    public List<Employee> searchPosEmp(String searchInfo){
        List<Employee> employees = new ArrayList<>();
        if(isNum(searchInfo)){
            employees.addAll(positionDao.searchPosEmpById(Integer.valueOf(searchInfo)));
        }
        employees.addAll(positionDao.searchPosEmpByName(searchInfo));
        employees.addAll(positionDao.searchPosEmpByType(searchInfo));
        return employees;
    }
    private boolean isNum(String str) {
        Matcher matcher = PATTERN.matcher(str);
        return matcher.matches();
    }
    /**
     * 插入岗位
     *
     * @param position
     */
    public void insertPosition(Position position) {
        positionDao.insertPosition(position);
    }

    /**
     * 修改岗位
     *
     * @param position
     */
    public void updatePosition(Position position) {
        positionDao.updatePosition(position);
    }

    /**
     * 删除岗位
     *
     * @param positionId
     */
    public void deletePositionById(Integer positionId) {
        positionDao.deletePositionById(positionId);
    }

    /**
     * 获取所有岗位信息
     *
     * @return
     */
    public List<Position> getAllPositions() {
        return positionDao.getAllPositions();
    }
}
