package com.wy.annotation.config;

import com.wy.annotation.bean.ColorFactoryBean;
import com.wy.annotation.bean.Person;
import com.wy.condition.LinuxCondition;
import com.wy.condition.WindowsCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Classname MainConfig
 * @Description 配置类 类中创建对象按顺序执行
 * 总结：
 * 给容器中注册组件：
 * 1）包扫描+组件标注注解（@Controller、@Service、@Component，@Repository）
 * 2)@Bean[导入第三方包里面的组件]
 * 3）Import[快速给容器中导入一个组件]
 *     1）@Import（要导入到容器中的组件）：容器中就会自动注册这个组件，id默认是全类名
 *     2）ImportSelector:返回需要导入的组件的全类名数组；
 *     3)ImportBeanDefinitionRegister：手动注册到bean容器中
 * 4）使用spring提供的FactoryBean（工厂bean）
 *     1）默认获取到的是工厂bean调用getObject创建的对象
 *     2）要获取工厂bean本身，我们需要给id前面加一个&来获取工厂bean
 *
 * @Date 2020/3/1 0001 14:33
 * @Created by wy
 */
//@Conditional(value = LinuxCondition.class)  // 满足当前条件，此配置类才会被加载，会被执行
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
//@ComponentScan(value = "com.wy", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION)
//})
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

  //  @Bean(value = "linus")  // value 表示注入到ioc容器中的对象名，也就是xml中的id
    @Conditional(value = LinuxCondition.class)
    public Person person02() {
        System.out.println("创建linus对象，并注入Person bean");
        return new Person("linus", 61);
    }

    //@Bean(value = "bill")
    @Conditional(value = WindowsCondition.class)
    public Person person01() {
        System.out.println("创建bill对象，并注入Person bean");
        return new Person("bill-gates", 62);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        System.out.println("创建colorFactoryBean对象，并注入到容器中");
        return new ColorFactoryBean();
    }

}
