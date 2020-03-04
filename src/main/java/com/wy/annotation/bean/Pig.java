package com.wy.annotation.bean;

import org.springframework.stereotype.Component;

/**
 * @Classname Pig
 * @Description TODO
 * @Date 2020/3/4 0004 22:41
 * @Created by wy
 */
@Component
public class Pig {

    public Pig() {
        System.out.println("Pig 创建bean" +
                "成功");
    }
}
