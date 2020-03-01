package com.wy.annotation.test;

import com.wy.annotation.bean.Person;
import com.wy.annotation.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname Test
 * @Description 测试类
 * @Date 2020/3/1 0001 14:23
 * @Created by wy
 */
public class Test {
    public static void main(String[] args) {
// 通过配置文件的方式
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person.getAge()+"===="+person.getName());
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        // 按照类型进行取值
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean.getAge()+"==="+bean.getName());
        // 通过类型 获取bean在spring中的名称 也就是id
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }
        // 通过名称获取注册在spring、中的bean
       Person person = (Person) applicationContext.getBean("person");
        System.out.println("age:"+person.getName()+"====="+"name"+person.getName());


    }
}
