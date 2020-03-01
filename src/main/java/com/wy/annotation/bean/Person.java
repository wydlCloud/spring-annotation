package com.wy.annotation.bean;

import lombok.Data;

/**
 * @Classname Person
 * @Description 实体类
 * @Date 2020/3/1 0001 14:33
 * @Created by wy
 */
@Data
public class Person {
    /**
     * 名字
     */
    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
