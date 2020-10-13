package spring.test.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.learn.config.InitAndDestroyConfig;
import spring.learn.config.JavaConfig;
import spring.learn.entity.Author;
import spring.learn.entity.Functions;
import spring.learn.service.BeanWayService;
import spring.learn.service.JSR250WayService;
import spring.learn.service.UseService;

public class SpringTestDmo {
    /**
     * 测试使用@Bean 的initMethod 和 destroyMethod
     *
     * 执行的时候是：
     *      1.先构造函数
     *      2.init方法
     *      3.终止程序的时候执行destroy方法
     * */
    @Test
    public  void testBeanInitDestroy(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitAndDestroyConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        System.out.println(beanWayService);

        JSR250WayService jSR250WayService = context.getBean(JSR250WayService.class);
        System.out.println(jSR250WayService);
        context.close();
    }


    /**
     * 测试使用@Scope注解将bean的创建设置为多例模式
     *
     * 执行结果：
     *             是否是同一个实例：false
     *             是否是同一个实例：true
     * */

    @Test
    public  void testScopePrototype(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // 获取多个Function 进行比较
        Functions functions1 = context.getBean(Functions.class);
        Functions functions2 = context.getBean(Functions.class);
        System.out.println("是否是同一个实例："+(functions1 ==functions2));

        // 获取多个 userService
        UseService service1 = context.getBean(UseService.class);
        UseService service2 = context.getBean(UseService.class);
        System.out.println("是否是同一个实例："+(service1 ==service2));
    }

    /*
    * 测试从properties引用单个值，多个值
    * */
    @Test
    public void testImportValuesFromProperties(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Author author = context.getBean(Author.class);
        System.out.println(author);
    }

    /*
    * 测试使用@Bean 注解进行javabean的创建
     */
    @Test
    public void testUseBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseService useService = context.getBean(UseService.class);
        System.out.println("useService:"+useService);
        useService.useFunctions("word");
    }


}
