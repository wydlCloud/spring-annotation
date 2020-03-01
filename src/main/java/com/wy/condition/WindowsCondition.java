package com.wy.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Classname WindowsCondition
 * @Description windows条件判断类
 * @Date 2020/3/1 0001 22:14
 * @Created by wy
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取ioc容器的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 获取项目的运行环境
        Environment environment = conditionContext.getEnvironment();
        // 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 获取注册bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        // 判断是否是linux环境
        if (environment.getProperty("os.name").contains("Windows")){
            return true;
        }
        return false;
    }
}
