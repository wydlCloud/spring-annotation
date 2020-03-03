package com.wy.annotation.bean;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname Car
 * @Description TODO
 * @Date 2020/3/3 10:43 下午
 */

public class Car {
    public Car() {
        System.out.println("car constructor...");
    }
    public void init(){
        System.out.println("car... init ...");
    }
    public void destory(){
        System.out.println("car ... destory");
    }
}
