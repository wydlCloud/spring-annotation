package IOCTest;

import com.wy.annotation.bean.Car;
import com.wy.annotation.bean.Cat;
import com.wy.annotation.bean.Person;
import com.wy.annotation.config.MainConfig;
import com.wy.annotation.config.MainConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Classname IocTest
 * @Description TODO
 * @Date 2020/3/1 0001 14:54
 * @Created by wy
 */
public class IocTest {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 根据对象类型获取对象的属性名称，在ioc容器初始化的时候，已经创建对象并注入到ioc容器中
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        // 动态获取项目的运行环境
        Environment environment = applicationContext.getEnvironment();
        // 获取运行环境的名称
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String className : beanNamesForType) {
            System.out.println(className);
        }
        // 获取所有的对象信息，根据对象类型
//        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
//        Person person = beansOfType.get("person");
//        System.out.println("张三"+person.getAge()+"----"+person.getName());
//        Person bill_gates = beansOfType.get("bill");
//        System.out.println("比尔盖茨"+bill_gates.getAge()+"-----"+bill_gates.getName());
//        Person linus = beansOfType.get("linus");
//        System.out.println("linus"+linus.getAge()+"-----"+linus.getName());
//        System.out.println(beansOfType);
    }


    @Test
    public void test() {
        // 在@Scope是单实例的情况下，创建ioc容器的时候，就会注入Person bean，
        // 如果是多实例的情况下，创建ioc的时候并不会注入bean，还是进行获取的时候，才会注入bean对象
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("创建ioc容器完成");
        Person bean = applicationContext.getBean(Person.class);
//        Person bean1 = applicationContext.getBean(Person.class);
//        System.out.println(bean.getName()+"===="+bean.getAge());
//        System.out.println(bean1.getName()+"====="+bean1.getAge());
//        System.out.println(bean==bean1);
        // 获取ioc容器中的bean名称
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name:beanDefinitionNames){
//            System.out.println(name);
//        }
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 根据对象类型获取对象的属性名称，在ioc容器初始化的时候，已经创建对象并注入到ioc容器中
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        // color对象是getBean的时候，在进行创建对象并注入到ioc中的，而@bean注解，没有其他限制条件，在初始化的时候，就会创建对象并初始化容器中
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean1 = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean2);
        System.out.println(colorFactoryBean.getClass());
        // 校验isSiglton 是否单例
        System.out.println(colorFactoryBean == colorFactoryBean1);


    }


    @Test
    public void test03() {
        // 创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        Car car = (Car) applicationContext.getBean("car");
        Cat cat = (Cat) applicationContext.getBean("cat");
        System.out.println("创建完成");
        System.out.println(car);

        applicationContext.close();


    }

}
