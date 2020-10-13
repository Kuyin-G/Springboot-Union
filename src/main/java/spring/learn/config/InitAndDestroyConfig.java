package spring.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.learn.service.BeanWayService;
import spring.learn.service.JSR250WayService;

@Configuration
@ComponentScan({"spring.learn"})
public class InitAndDestroyConfig {

    /**
     *  使用JSR250来设置bean 的init方法和destroy方法
     *  在JSR250WayService使用了注解：@PostConstruct 和 @PreDestroy
     * */
    @Bean
    public JSR250WayService jsr250WayService(){
        return  new JSR250WayService();
    }

    /**
     *  测试@Bean 的initMethod 和 destroyMethod
     * */
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return  new BeanWayService();
    }
}
