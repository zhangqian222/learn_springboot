package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {
    @RequestMapping("/goto")
    public String m_goto(HttpServletRequest request) {
        request.setAttribute("mycolor", "yellor");
        return "forward:/success";
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map<String, String> m_success(
            @RequestAttribute(name = "mycolor") String mycolor,
            HttpServletRequest request
    ) {
        Map<String, String> stringStringMap = new HashMap<>();
        //两种方法获取参数
        //1.利用注解
        stringStringMap.put("myc", mycolor);
        //2.利用原生request
        String mycolor1 = (String) request.getAttribute("mycolor");
        stringStringMap.put("mycolor1", mycolor1);
        return stringStringMap;
    }

    @ResponseBody
    @RequestMapping("/path/{sell}")
    public Map getSell(@MatrixVariable("color") List<String> colors,
                       @MatrixVariable("name") String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("color", colors);
        map.put("name", name);
        return map;
    }
}
