package spring.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("spring.learn.schedue")
@EnableScheduling // 开启计划任务的注解的支持
public class ScheduleConfig {
}
