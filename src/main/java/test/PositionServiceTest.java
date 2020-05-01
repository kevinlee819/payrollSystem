package test;

import com.hust.beans.Employee;
import com.hust.beans.Position;
import com.hust.service.PositionService;
import javafx.geometry.Pos;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 宁鑫
 * @date 2019/6/20
 * @time 19:24
 **/
public class PositionServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    PositionService positionService = (PositionService)context.getBean("positionService");
    @Test
    public void insertPosition() {
        Position position = new Position("搬砖", "java工程师", 19);
        for(int i = 0; i < 20; i++){
            positionService.insertPosition(position);
        }

    }

    @Test
    public void updatePosition() {
        Position position = new Position(3,"搬砖", "java工程师", 19);
        positionService.updatePosition(position);
    }

    @Test
    public void deletePositionById() {
        positionService.deletePositionById(1);
    }

    @Test
    public void getAllPositions() {
        positionService.getAllPositions();
    }

    @Test
    public void searchPosListByNameOrType() {
        List<Position> positions = positionService.searchPosListByNameOrType("搬砖");
        for(Position p : positions){
            System.out.println(p.getPositionName());
        }
    }
}