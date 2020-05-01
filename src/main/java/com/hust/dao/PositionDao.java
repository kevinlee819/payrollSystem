package com.hust.dao;

import com.hust.beans.Employee;
import com.hust.beans.Position;

import java.util.List;

/**
 * @author lkj
 * @date 2019/6/20
 * @time 16:51
 **/
public interface PositionDao {

    List<Employee> searchPosEmpById(int posId);
    List<Employee> searchPosEmpByType(String posType);
    List<Employee> searchPosEmpByName(String posName);
    /**
     * 插入岗位
     * @param position
     */
    void insertPosition(Position position);

    /**
     * 修改岗位
     * @param position
     */
    void updatePosition(Position position);

    /**
     * 删除岗位
     * @param positionId
     */
    void deletePositionById(Integer positionId);

    /**
     * 获取所有岗位信息
     * @return
     */
    List<Position> getAllPositions();
    /**
     * 通过岗位名称或类型搜索岗位列表
     * @param s
     * @return
     */
    List<Position> searchPosListByNameOrType(String s);
}
