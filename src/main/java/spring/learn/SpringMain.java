package spring.learn;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.learn.config.JavaConfig;
import spring.learn.service.UseService;

@ComponentScan
public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseService useService = context.getBean(UseService.class);
        System.out.println("useService:"+useService);
        useService.useFunctions("word");
    }
}
