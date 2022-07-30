package com.zq.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {
    @RequestMapping(value = "/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable(name = "id") int id,
                                      @PathVariable(name = "username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") int age,
                                      @RequestParam("aa") String aa,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("Idea-8296e770") String cookie1
//                                      @CookieValue Map<String, String> cookie

    ) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
//        stringObjectHashMap.put("id", id);
//        stringObjectHashMap.put("name", name);
//        stringObjectHashMap.put("pv", pv);
        stringObjectHashMap.put("header", headers);
//        stringObjectHashMap.put("User-Agent", userAgent);
//        stringObjectHashMap.put("params", params);
//        stringObjectHashMap.put("aa", aa);
        stringObjectHashMap.put("cookie1", cookie1);
//        stringObjectHashMap.put("cookie", cookie);
        return stringObjectHashMap;
    }

    @PostMapping("/requestBody")
    public Map<String, Object> getRequestbody(@RequestBody String content) {
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("content", content);
        return stringObjectMap;

    }

    @GetMapping("/testParam")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        //1
        map.put("name", "zhangq");
        //2
        model.addAttribute("mname", "zhangq2");
        //3
        request.setAttribute("rname", "zhangqian3");
        //4
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        response.addCookie(cookie);

        return "forward:/success2";
    }

    @ResponseBody
    @RequestMapping("/success2")
    public Map success(HttpServletRequest request) {
        Object rname = request.getAttribute("rname");
        Object mname = request.getAttribute("mname");
        Object name = request.getAttribute("name");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("rname", rname);
        stringObjectHashMap.put("mname", mname);
        stringObjectHashMap.put("name", name);
        return stringObjectHashMap;
    }
}
