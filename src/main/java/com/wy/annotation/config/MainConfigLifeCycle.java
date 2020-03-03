package com.wy.annotation.config;

import com.wy.annotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MainConfigLifecYCLE
 * @Description TODO
 * @Date 2020/3/3 10:41 下午
 *
 * bean的生命周期：
 *    bean创建--初始化--销毁的过程
 *    容器管理bean的生命周期
 *    我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自动以的初始化和销毁
 *
 *    构造（对象创建）
 *    单实例：在容器启动的时候创建对象
 *    多实例：在每次实际获取对象的时候，才会创建对象
 *    初始化：
 *    单实例：对象创建完成，并赋值好，调用初始化方法
 *    多实例：在每次实际获取对象的时候，才会创建对象，并调用初始化方法
 *    销毁：
 *    单实例：容器关闭的时候
 *    多实例：容器不会管理bean，自己去解决
 *   1. 通过注解的方式实现初始化和销毁
 *    1）指定初始化和销毁的方法
 *   2.通过让bean实现InitializingBean(定义初始化方法逻辑)、
 *     通过让bean实现DisposableBean（定义销毁方法逻辑）
 */
@Configuration
@ComponentScan(value = "com.wy.annotation.bean")
public class MainConfigLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        System.out.println("car=======");
        return new Car();
    }

}
