package com.wy.annotation.config;

import com.wy.annotation.bean.Person;
import com.wy.condition.LinuxCondition;
import com.wy.condition.WindowsCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Classname MainConfig
 * @Description 配置类 类中创建对象按顺序执行
 * @Date 2020/3/1 0001 14:33
 * @Created by wy
 */
@Conditional(value = LinuxCondition.class)  // 满足当前条件，此配置类才会被加载，会被执行
// 配置类==配置文件
@Configuration  // 通过此注解主要是告诉spring这个是个配置类
//@ComponentScan(value = "com.wy") // 指定要扫描的包
// 指定要扫描的包，并按照规则排除包下的内容
//@ComponentScan(value = "com.wy",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
// 指定要扫描的包，并按照规则只包含包下的内容
// 默认的规则是扫描所有的，所以要禁用默认规则才会生效
//@ComponentScan(value = "com.wy",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
//},useDefaultFilters = false)
@ComponentScan(value = "com.wy", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION)
})
public class MainConfig {
    // 给容器中注册一个bean；类型为返回值类型 id默认是方法名作为id 也就是person
    @Bean(value = "person") // 注解就是表示往spring中注入bean
    //@Scope(value = "prototype") // 单实例，默认就是单实例的  ConfigurableBeanFactory SCOPE_SINGLETON  singleton
    //@Lazy
    // 懒加载 在容器初始化的时候，并不会创建bean，并注入ioc容器中，只有在使用的时候才会进行注入到ioc容器中，
    // 默认不是懒加载模式，在ioc容器初始化的时候，就会把bean对象创建并注入到ioc容器汇中
    public Person person() {
        System.out.println("创建Person对象，并注入Person bean");
        return new Person("lisi", 20);
    }

    @Bean(value = "linus")  // value 表示注入到ioc容器中的对象名，也就是xml中的id
    @Conditional(value = LinuxCondition.class)
    public Person person02() {
        System.out.println("创建linus对象，并注入Person bean");
        return new Person("linus", 61);
    }

    @Bean(value = "bill")
    @Conditional(value = WindowsCondition.class)
    public Person person01() {
        System.out.println("创建bill对象，并注入Person bean");
        return new Person("bill-gates", 62);
    }
}
