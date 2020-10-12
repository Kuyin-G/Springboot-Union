package spring.learn.entity;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// 指定properties文件，springboot会自动加载application.properties
// 但是spring不会自动是加载该文件，需要使用PropertySource注解到文件
@PropertySource("classpath:application.properties")
// 使用注解导入properties中的值
@Component
@ConfigurationProperties(prefix = "author")
public class Author {
    private Integer id;
    private String name;
    private Integer age;
}
