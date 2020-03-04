package com.wy.annotation.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname Pig
 * @Description TODO
 * @Date 2020/3/4 0004 22:06
 * @Created by wy
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor bean创建对象初始化创建方法");
    }
// bean创建之后，在初始化方法之前调用  bean创建的bean  beanName 创建的bean的名称
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor 在bean初始化之前进行调用方法:"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor 在bean初始化之后进行调用此方法"+beanName);
        return bean;
    }
}
