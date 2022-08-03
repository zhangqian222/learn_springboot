package com.zq.controller;

import com.zq.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    //处理登陆请求
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if ((StringUtils.hasLength(user.getUserName()) && user.getPassword().equals("123456"))) {
            //把user存到session中
            session.setAttribute("loginUser", user);
            //登陆成功
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "登陆失败！");
            //登陆失败，回到登陆页
            return "login";
        }
    }

    @GetMapping("main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            //回到登陆页面
            model.addAttribute("msg", "登陆超时，请重新登陆");
            return "login";
        }
    }
}
