package spring.learn.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.learn.entity.Functions;
import spring.learn.service.BeanWayService;
import spring.learn.service.JSR250WayService;
import spring.learn.service.UseService;

/**
 * 使用 @Configuration 声明该类是配置类，可以使用@Bean添加相应的javabean组件
 * */
@ComponentScan({"spring.learn"})
@Configuration
public class JavaConfig {



    /**
     *  Scope：Srping如何创建bean的实例的
     *      1.Singleton：单例，默认设置，
     *      2.Prototype：多例，每次调用创建一个bean
     *      3.Request：Web项目中，给每个http request 创建一个新的bean实例
     *      4.Session：Web项目中，给每个http session 创建一个新的bean实例
     *      5.GlobalSession: 这个旨在portal应用中有用，给每一个global http session 新建一个bean实例
     *
     * */

    //测试多例模式：
    @Bean
    @Scope("prototype")
    public Functions functions(){
        return new Functions();
    }

    @Bean
    @Scope("singleton") // spring默认就是singleton
    public UseService useService(){
        UseService useService11 = new UseService();
        useService11.setFunctions(new Functions());
        return useService11;
    }




}
