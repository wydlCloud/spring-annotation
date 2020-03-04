package com.wy.annotation.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Classname Dog
 * @Description
 * @Date 2020/3/4 0004 21:47
 * @Created by wy
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("Dog 对象  bean创建成功");
    }
    @PostConstruct
    public void init(){
        System.out.println("Dog对象创建成功 调用初始化方法");
    }
    @PreDestroy
    public void destory(){
        System.out.println(
                "Dog对象创建成功 调用销毁方法"
        );
    }
}
