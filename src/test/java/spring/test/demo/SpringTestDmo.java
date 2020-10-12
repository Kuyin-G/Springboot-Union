package spring.test.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.learn.config.JavaConfig;
import spring.learn.entity.Author;
import spring.learn.service.UseService;

public class SpringTestDmo {

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
