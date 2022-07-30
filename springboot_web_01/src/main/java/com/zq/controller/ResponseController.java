package com.zq.controller;

import com.zq.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
@ResponseBody
@Controller
public class ResponseController {

@RequestMapping("/getPerson")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(333);
        person.setBirth(new Date());
        person.setUsername("jhon");
        return person;
    }
}
