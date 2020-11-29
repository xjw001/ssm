package com.xjw.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjw.bean.User;
import com.xjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/inter")
public class InterController {

    private int count;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/testinterceptor")
    public String testInterceptor() {
        System.out.println("测试拦截器");
        return "list";
    }

    @RequestMapping(value="/getAllUser")
    //@ResponseBody
    public String getAllUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {
        System.out.println("查询用户成功");
        try {
            PageHelper.startPage(pageNum,20);
            //紧跟着的查询就是一个分页查询
            List<User> allUsers = userService.getAllUsers();
            PageInfo pageinfo = new PageInfo(allUsers,5);//5-》连续显示的页面
            model.addAttribute("pageInfo",pageinfo);
            return JSONObject.toJSONString(allUsers);
        }catch (Exception e){
            System.out.println("出错了!");
            e.printStackTrace();
        }
        return "空";
    }
}
