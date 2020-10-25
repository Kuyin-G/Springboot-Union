package spring.learn.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("spring.learn.aop")
@EnableAspectJAutoProxy // 开启Aop的功能
public class AopConfig {
}
