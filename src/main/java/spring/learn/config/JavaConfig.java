package spring.learn.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.UsesSunMisc;
import spring.learn.entity.Functions;
import spring.learn.service.UseService;

/**
 * 使用 @Configuration 声明该类是配置类，可以使用@Bean添加相应的javabean组件
 * */
@Configuration
public class JavaConfig {

    @Bean
    public Functions functions(){
        return new Functions();
    }

    @Bean
    public UseService useService(){
        UseService useService11 = new UseService();
        useService11.setFunctions(new Functions());
        return useService11;
    }


}
