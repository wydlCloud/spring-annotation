package com.wy.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname Cat
 * @Description 主要是bean的生命周期初始化和销毁
 * @Date 2020/3/3 10:56 下午
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("可以表示为初始化的时候调用");
    }

    public void destroy() throws Exception {
        System.out.println("可以表示为销毁的时候调用");
    }
}
