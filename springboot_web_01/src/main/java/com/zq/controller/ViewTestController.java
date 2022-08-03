package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTestController {

    @RequestMapping("/helloSuccess")
    public String helloSuccess(Model model) {
        model.addAttribute("msg", "hello,world!!!!!!!!");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }
}
