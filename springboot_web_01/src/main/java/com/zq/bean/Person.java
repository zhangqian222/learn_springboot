package com.zq.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String username;
    private Integer age;
    private Date birth;
    private Pet pet;
}
