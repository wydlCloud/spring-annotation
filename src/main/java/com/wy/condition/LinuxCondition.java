package com.wy.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Classname Linux
 * @Description linux条件判断类
 * @Date 2020/3/1 0001 22:13
 * @Created by wy
 */
public class LinuxCondition implements Condition {
    /**
     *condition 匹配规则，校验规则
     * @param conditionContext 判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata 注解信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取ioc容器的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 获取项目的运行环境
        Environment environment = conditionContext.getEnvironment();
        // 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 获取注册bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        // 判断容器中是否包含person对象
        boolean person = registry.containsBeanDefinition("bill");
        // 判断是否是linux环境
        if (environment.getProperty("os.name").contains("linux")||person==true){
            return true;
        }
        return false;
    }
}
