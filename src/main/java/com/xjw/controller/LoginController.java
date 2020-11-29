package com.xjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("登录页面");
       return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request,String userName,String password){
        System.out.println("开始登录!");
        request.getSession().setAttribute("users","xiongjw");
        return "list_asy";
    }
}
