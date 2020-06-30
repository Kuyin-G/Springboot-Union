package example.kuyin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ActiveMqMain {

    public static void main(String[] args) {
        SpringApplication.run(ActiveMqMain.class,args);
    }
}
