package com.hust.controller;

import com.hust.beans.Employee;
import com.hust.beans.User;
import com.hust.dao.UserDao;
import com.hust.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/18
 * @time 9:02
 **/
@Controller
public class MainController {
    @Autowired
    private EmployeeService employeeService;

    private UserDao userDao;
    @Autowired
    public MainController(UserDao userDao){
        this.userDao = userDao;
    }
    @ModelAttribute("employee")
    public Employee createEmployee(){
        return new Employee();
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("main")
    public String main(){
        return "mainWindow";
    }

    /**
     * 登录验证
     * @param password
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "dologin", params = {"userName", "password"},method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> dologin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        User user = new User(userName, password);
        int verifyRes = userDao.existsUser(user);
        Map<String, Integer> map = new HashMap<>(1);
        //登录成功
        if(verifyRes == 1){
            session.setAttribute("USER_SESSION", user);
            map.put("code", 1);
            return map;
        }
        map.put("code", 0);
        return map;
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping(value = "changePassword", params = {"old", "new"},method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> changePassword(@RequestParam("old") String oldPass, @RequestParam("new") String newPass, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        User user = new User("admin", oldPass);
        Map<String, Integer> map = new HashMap<>(1);
        //修改密码
        if(userDao.existsUser(user) == 1){
            user.setPassword(newPass);
            userDao.updateUser(user);
            map.put("code", 1);
            return map;
        }
        map.put("code", 0);
        return map;
    }
}
