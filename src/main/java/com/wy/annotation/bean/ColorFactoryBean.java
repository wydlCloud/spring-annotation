package com.wy.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname ColorFactoryBean
 * @Description TODO
 * @Date 2020/3/3 9:35 下午
 */
// 创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    // 返回一个color对象，这个对象会返回到容器中
    public Color getObject() throws Exception {
        System.out.println("getObejct 创建对象并且注入到ioc容器中");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }
// 是否是单例  true 返回的是单例，如果是false返回的是多实例，每次获取都会创建一个新的，这个时候每次都会调用getObject（）创建对象
    public boolean isSingleton() {
        return true;
    }
}
