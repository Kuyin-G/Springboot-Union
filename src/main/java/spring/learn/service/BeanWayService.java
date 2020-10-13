package spring.learn.service;



/**
 *  测试bean实例的初始化和销毁
 *      在bean的使用之前和使用之后做一些必要的工作，
 *      凡是有两种：
 *          1.java配置方式：使用@Bean 注解中的initMethod 和destoryMethod
 *          （xml配置中是init-method 和 destroy-method）
 *
 *          2.注解方式：利用JSR-250的PostConst 和 PreDestroy
 * */

// 方式1：java配置方式
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("BeanWayService构造函数");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }

}
