package com.wy.annotation.config;

import com.wy.annotation.bean.Car;
import com.wy.annotation.bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MainConfigLifeCycle
 * @Description TODO
 * @Date 2020/3/3 10:41 下午
 *
 * bean------的过程
 * IOC容器管理bean的生命周期；但我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 构造（对象创建）
 *
 * 单实例：在容器启动的时候创建对象
 * 多实例：在每次获取的时候创建对象
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 * 对象创建完成，并赋值好，调用初始化方法。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 * 单实例：容器关闭的时候
 * 多实例：容器不会管理这个bean；容器不会调用销毁方法；
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * initializeBean
 * {
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 * 指定初始化和销毁方法；
 * 通过@Bean指定init-method和destroy-method；
 * 通过让Bean实现InitializingBean（定义初始化逻辑），
 * DisposableBean（定义销毁逻辑）;
 * 可以使用JSR250；
 * @PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 * @PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * BeanPostProcessor【interface】：bean的后置处理器；
 * 在bean初始化前后进行一些处理工作；
 * postProcessBeforeInitialization:在初始化之前工作
 * postProcessAfterInitialization:在初始化之后工作
 */
@Configuration
@ComponentScan(value = "com.wy.annotation.bean")
public class MainConfigLifeCycle {

    //@Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        System.out.println("car=======");
        return new Car();
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        System.out.println("创建colorFactoryBean对象，并注入到容器中");
        return new ColorFactoryBean();
    }

}
