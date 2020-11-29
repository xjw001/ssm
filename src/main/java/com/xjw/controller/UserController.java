package com.xjw.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjw.bean.Msg;
import com.xjw.bean.User;
import com.xjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController{

    private int count;

    @Autowired
    private UserService userService;

    @PostMapping(value="/addUser")
    @ResponseBody
    public Msg addUser(User user) {
        try {
            int ndexNum = userService.getMaxUserId() + 1;
            user.setUid(ndexNum);
            user.setCreatetime(new Timestamp(System.currentTimeMillis()));
            userService.saveUser(user);
            return Msg.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    /**
     * json格式的数据
     * @param pageNum
     * @return
     */
    @RequestMapping(value="/getAllUserJson")
    @ResponseBody
    public Msg getAllUserJson(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        System.out.println("pageNum:" + pageNum);
        //紧跟着的查询就是一个分页查询
        long time1 = System.currentTimeMillis();
        List<User> allUsers = userService.getAllUsers();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        PageInfo pageInfo = new PageInfo(allUsers,5);//5-》连续显示的页面
        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping(value="/getAllUserAsy")
    public String getAllUserAsy(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {
        System.out.println("查询用户成功");
        try {
            PageHelper.startPage(pageNum,10);
            //紧跟着的查询就是一个分页查询
            long time1 = System.currentTimeMillis();
            List<User> allUsers = userService.getAllUsers();
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
            PageInfo pageinfo = new PageInfo(allUsers,5);//5-》连续显示的页面
            model.addAttribute("pageInfo",pageinfo);
            return "list_asy";
        }catch (Exception e){
            System.out.println("出错了!");
            e.printStackTrace();
        }
        return "空";
    }

    @RequestMapping(value="/getAllUser")
    public String getAllUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {
        System.out.println("查询用户成功");
        try {
            PageHelper.startPage(pageNum,10);
            //紧跟着的查询就是一个分页查询
            List<User> allUsers = userService.getAllUsers();
            PageInfo pageinfo = new PageInfo(allUsers,5);//5-》连续显示的页面
            model.addAttribute("pageInfo",pageinfo);
            return "list";
        }catch (Exception e){
            System.out.println("出错了!");
            e.printStackTrace();
        }
        return "空";
    }
}
